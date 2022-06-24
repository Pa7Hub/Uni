package Q3.exams.programming.cheatsheets.pattern.template;

public class NormalLifter extends WeightLifter {
    @Override
    void init() {
        System.out.println("Prepares to bench 70kg 12 reps");
    }

    @Override
    void startLifting() {
        System.out.println("Nervously starts lifting");
    }

    @Override
    void stopLifting() {
        System.out.println("Stopped at rep 7");
    }
}
