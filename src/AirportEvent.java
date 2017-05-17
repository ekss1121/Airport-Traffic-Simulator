//YOUR NAME HERE

public class AirportEvent extends Event {
    public static final int PLANE_ARRIVES = 0;
    public static final int PLANE_LANDED = 1;
    public static final int PLANE_DEPARTS = 2;
    public static final int PLANE_TAKEOFF = 3;
    private Airplane m_airplane;
    AirportEvent(double delay, EventHandler handler, int eventType, Airplane airplane) {
        super(delay, handler, eventType);
        m_airplane = airplane;

    }

    public Airplane getPlane(){
        return m_airplane;
    }
}
