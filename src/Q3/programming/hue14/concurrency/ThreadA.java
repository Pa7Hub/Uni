package Q3.programming.hue14.concurrency;

public class ThreadA extends Thread {

    @Override
    public void run() {
        RunnableA runnableA = new RunnableA(2);
        runnableA.run();
    }

}
