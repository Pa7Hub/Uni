package Q3.programming.hue16.Main;

import Q3.programming.hue16.SubTravelCenter;

/**
 * So this rly just isn't working yet, but idk if the task wants us to get this working, because it obviously says that there will be deadlocks in this system.
 */
public class Main {
    // FIXME so right now this just freezes after a while, as the threads run into a wait() deadlock pretty fast
    // FIXME pressing Interrupt All will re-run the threads and then interrupt them, so theres a small interval where they start booking/canceling again
    public static void main(String[] args) {
        SubTravelCenter center = new SubTravelCenter("The most amazing Management System");
    }
}
