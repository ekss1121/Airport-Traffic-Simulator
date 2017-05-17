//YOUR NAME HERE

// Added number of passengers, speed
// Airplane: Boeing 737-700


public class Airplane {
    private static int m_capacity = 150;
    private int m_nameCode;
    private int m_numberPassengers;
    private double m_speed= 838.0; //[km/h]
    public int m_originAirport;
    public int m_desAirport;
    private double distance;
    private double arrivingTime;
    private double landingTime;
    private Airmap map;
    public Airplane(int originAirport, int desAirport) {
        m_nameCode = 0;
        m_originAirport = originAirport;
        m_desAirport = desAirport;
        map = new Airmap(m_originAirport, m_desAirport);
        m_numberPassengers = 0;
    }

    public void setName(int i) {

        m_nameCode = m_originAirport*10000 + m_desAirport* 1000 + i;
    }
    public int getName(){
        return m_nameCode;
    }
    public int getPassNum(){
        return m_numberPassengers;
    }
    public void setPassNum(int num){ m_numberPassengers = num;}
    public double getFlightTime(){
        distance = map.getDistance();
        return (distance / m_speed) * 60.0; //[min]
    }

    public int getM_capacity(){ return m_capacity;};

    public void set_arrivingTime(double time ){arrivingTime = time;}
    public void set_landingTime (double time ){landingTime = time;}

    public double get_arrivingTime(){ return arrivingTime;}
    public double get_landingTime() {return landingTime;}


}


