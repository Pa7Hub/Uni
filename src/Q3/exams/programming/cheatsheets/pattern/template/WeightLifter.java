package Q3.exams.programming.cheatsheets.pattern.template;

/**
 * Das "Skeleton" von dem die einzelnen Implementierungen erben.
 */
public abstract class WeightLifter {
    abstract void init();
    abstract void startLifting();
    abstract void stopLifting();

    public final void lift() {
        init();
        startLifting();
        stopLifting();
    }
}
