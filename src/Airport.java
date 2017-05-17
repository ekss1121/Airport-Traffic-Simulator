//YOUR NAME HERE
// import java utility

import java.util.*;
public class Airport implements EventHandler {

    //TODO add landing and takeoff queues, random variables
    private Queue <AirportEvent> runwayQueue = new LinkedList <AirportEvent>();
    Random rand = new Random();

    private double m_runwayTime;
    private double m_requiredTimeOnGround;

    private String m_airportName;
    private int m_arrivePassengers;
    private int m_departPassengers;
    private double m_circlingTime;
    private double m_nextWindow;

    Airport(String name, double runwayTime, double requiredTimeOnGround) {
        m_airportName = name;
        m_circlingTime = 0;
        m_arrivePassengers = 0;
        m_departPassengers = 0;
        m_runwayTime = runwayTime;
        m_requiredTimeOnGround = requiredTimeOnGround;
        m_nextWindow = 0;
    }

    public String getName() {
        return m_airportName;
    }

    public void handle(Event event) {
        AirportEvent airEvent = (AirportEvent)event;

        switch(airEvent.getType()) {
            case AirportEvent.PLANE_ARRIVES:

                // Add the new arrive event to the runwayQueue
                runwayQueue.offer(airEvent);
                System.out.println(AirportSim.formatter.format(Simulator.getCurrentTime()) +
                        " Flight: " +airEvent.getPlane().getName() + " arrived at "+ this.getName());

                airEvent.getPlane().set_arrivingTime(Simulator.getCurrentTime());
                AirportEvent landedEvent = new AirportEvent(
                        m_nextWindow- Simulator.getCurrentTime(), this, AirportEvent.PLANE_LANDED, airEvent.getPlane());
                Simulator.schedule(landedEvent);
                //m_lastWindow = m_nextWindow;
                break;

            case AirportEvent.PLANE_DEPARTS:

                if (m_nextWindow < Simulator.getCurrentTime()){
                    m_nextWindow = Simulator.getCurrentTime() + m_runwayTime;
                }else{
                    m_nextWindow = m_nextWindow + m_runwayTime;
                }
                // Boarding random number of passengers 130~150
                airEvent.getPlane().setPassNum(rand.nextInt(10)*20 + airEvent.getPlane().getM_capacity() - 20);
                AirportEvent takeoffEvent = new AirportEvent(
                        m_nextWindow - Simulator.getCurrentTime(), this, AirportEvent.PLANE_TAKEOFF, airEvent.getPlane());

                Simulator.schedule(takeoffEvent);

                //m_lastWindow = m_nextWindow;
                break;

            case AirportEvent.PLANE_TAKEOFF:
                System.out.println(
                        AirportSim.formatter.format(Simulator.getCurrentTime())+" Flight: " +airEvent.getPlane().getName() +" left from "+this.getName());
                m_departPassengers += airEvent.getPlane().getPassNum();

                int destination = airEvent.getPlane().m_desAirport;
                Airport next_handler = AirportSim.airports.returnAirport(destination);
                double flyTime = airEvent.getPlane().getFlightTime();
                AirportEvent arriveEvent = new AirportEvent(
                        flyTime, next_handler, AirportEvent.PLANE_ARRIVES, airEvent.getPlane());
                Simulator.schedule(arriveEvent);
                break;

            case AirportEvent.PLANE_LANDED:
                System.out.println(AirportSim.formatter.format(Simulator.getCurrentTime() )+
                        " Flight: " +airEvent.getPlane().getName() +" landed at " + this.getName());

                // get Number of arriving passengers
                m_arrivePassengers += airEvent.getPlane().getPassNum();
                airEvent.getPlane().set_landingTime(Simulator.getCurrentTime());
                m_circlingTime += airEvent.getPlane().get_landingTime() - airEvent.getPlane().get_arrivingTime() - m_runwayTime;
                // switch destination and origin
                int temp = airEvent.getPlane().m_desAirport;
                airEvent.getPlane().m_desAirport = airEvent.getPlane().m_originAirport;
                airEvent.getPlane().m_originAirport = temp;
                AirportEvent departureEvent = new AirportEvent(
                        m_requiredTimeOnGround, this, AirportEvent.PLANE_DEPARTS, airEvent.getPlane());
                Simulator.schedule(departureEvent);

                break;
        }
    }

    public double getM_circlingTime(){
        return m_circlingTime;
    }

    public int getM_arrivePassengers(){
        return m_arrivePassengers;
    }

    public int getM_departPassengers() {return m_departPassengers; }
}
