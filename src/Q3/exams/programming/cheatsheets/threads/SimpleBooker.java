package Q3.exams.programming.cheatsheets.threads;


public class SimpleBooker {
    private Integer _bookedThings = 0;
    private Integer _maxAmountOfBookedThings = 5;

    public synchronized void book() throws InterruptedException {
        // Bedingtes Warten
        while (this._bookedThings >= _maxAmountOfBookedThings) {
            this.wait();
        }

        /*
            Das hier ist noch nicht richtig, man müsste hier nochmal checken, ob die Bedingung stimmt. Ansonsten würden wir nach dem wecken der Threads ganz viele Buchungen haben,
            auch obwohl nur ein Slot frei ist.
         */
        this._bookedThings++;
        notify();
    }

    public synchronized void cancel() throws InterruptedException {
        while (this._bookedThings <= 0) {
            wait();
        }

        // s.o.
        this._bookedThings--;
        notify();
    }

    public Integer getBookedThings() {
        return this._bookedThings;
    }


}
