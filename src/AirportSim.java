//Zhihang Liu

//import java.util.TreeSet;

import java.util.Random;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class AirportSim {

    static NumberFormat formatter = new DecimalFormat("#0.0000");
    static CreateAirport airports = new CreateAirport();
    private static final int FLIGHT_NUM = 25;

    public static void main(String[] args) {

        // Initializing airplanes
        for(int i=0; i< FLIGHT_NUM; ++i){
            Random rand = new Random();
            int origin = 0;
            int destination = 0;
            while (origin == destination){
                origin = rand.nextInt(5) +1;
                destination = rand.nextInt(5) +1;
            }
            Airplane plane = new Airplane(origin, destination);
            plane.setName(i);
            Airport handler = airports.returnAirport(origin);
            AirportEvent takeoffEvent = new AirportEvent(0, handler, AirportEvent.PLANE_DEPARTS, plane);
            Simulator.schedule(takeoffEvent);
        }

        Simulator.stopAt(1440);
        Simulator.run();

        // Output circling time for each airports
        System.out.println("=============Atlanta ATL==============");
        System.out.println("Circling time = " + formatter.format(airports.atl.getM_circlingTime()));
        System.out.println("Arriving Passengers = " + airports.atl.getM_arrivePassengers());
        System.out.println("Departing Passengers = " + airports.atl.getM_departPassengers());
        System.out.println("=============New York JFK==============");
        System.out.println("Circling time = " + formatter.format(airports.jfk.getM_circlingTime()));
        System.out.println("Arriving Passengers = " + airports.jfk.getM_arrivePassengers());
        System.out.println("Departing Passengers = " + airports.jfk.getM_departPassengers());
        System.out.println("=============Boston BOS===============");
        System.out.println("Circling time = " + formatter.format(airports.bos.getM_circlingTime()));
        System.out.println("Arriving Passengers = " + airports.bos.getM_arrivePassengers());
        System.out.println("Departing Passengers = " + airports.bos.getM_departPassengers());
        System.out.println("=============Chicago ORD==============");
        System.out.println("Circling time = " + formatter.format(airports.ord.getM_circlingTime()));
        System.out.println("Arriving Passengers = " + airports.ord.getM_arrivePassengers());
        System.out.println("Departing Passengers = " + airports.ord.getM_departPassengers());
        System.out.println("=============Los Angles LAX===========");
        System.out.println("Circling time = " + formatter.format(airports.lax.getM_circlingTime()));
        System.out.println("Arriving Passengers = " + airports.lax.getM_arrivePassengers());
        System.out.println("Departing Passengers = " + airports.lax.getM_departPassengers());

    }
}
