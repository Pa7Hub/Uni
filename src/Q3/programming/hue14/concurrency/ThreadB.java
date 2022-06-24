package Q3.programming.hue14.concurrency;

public class ThreadB extends Thread {

    @Override
    public void run() {
        RunnableB runnableB = new RunnableB(2);
        runnableB.run();
    }

}
