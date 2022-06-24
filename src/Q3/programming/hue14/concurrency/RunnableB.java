package Q3.programming.hue14.concurrency;

public class RunnableB implements Runnable {
    Integer _amountOfRounds;

    public RunnableB(Integer n) {
        this._amountOfRounds = n;
    }

    @Override
    public void run() {
        for (int i = 0; i < this._amountOfRounds; i++) {
            System.out.println("b" + i);
        }
    }

}
