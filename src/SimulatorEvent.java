//YOUR NAME HERE


public class SimulatorEvent extends Event {
    public static final int STOP_EVENT = 0;

    SimulatorEvent(double delay, EventHandler handler, int eventType) {
        super(delay, handler, eventType);
    }
}
