package Q3.exams.programming.cheatsheets.pattern.template;

public class StrongLifter extends WeightLifter {
    @Override
    void init() {
        System.out.println("Preparing to bench 100kg 12 reps");
    }

    @Override
    void startLifting() {
        System.out.println("Starts benching");
    }

    @Override
    void stopLifting() {
        System.out.println("Pulled it off");
    }
}
