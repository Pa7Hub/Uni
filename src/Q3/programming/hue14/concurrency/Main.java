package Q3.programming.hue14.concurrency;

public class Main {
    public static void main(final String[] args) {
        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();
        threadA.start();
        threadB.start();
    }
}
