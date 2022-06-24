package Q3.programming.hue14.concurrency;

public class RunnableA implements Runnable {
    Integer _amountOfRounds;

    public RunnableA(Integer n) {
        this._amountOfRounds = n;
    }

    @Override
    public void run() {
        for (int i = 0; i < this._amountOfRounds; i++) {
            System.out.println("a" + i);
        }
    }

}
