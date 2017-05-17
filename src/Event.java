//YOUR NAME HERE

public class Event implements Comparable<Event> {
    private EventHandler m_handler;
    private double m_time;
    private int m_eventId;
    private int m_eventType;
    static private int m_nextId = 0;

    Event() {
        m_eventId = m_nextId++;

    }

    Event(double delay, EventHandler handler, int eventType) {
        this();
        m_time = delay;
        m_handler = handler;
        m_eventType = eventType;
    }

    public int getId() {
        return m_eventId;
    }

    public double getTime() {
        return m_time;
    }

    public void setTime(double time) {
        m_time = time;
    }

    public EventHandler getHandler() {
        return m_handler;
    }

    public int getType() { return m_eventType; }

    public void setHandler(EventHandler handler) {
        m_handler = handler;
    }

    @Override
    public int compareTo(final Event ev) {
        int timeCmp = Double.compare(m_time, ev.getTime());
        if(timeCmp != 0) {
            return timeCmp;
        }
        else
            return Integer.compare(m_eventId, ev.getId());
    }
}
