package Q3.exams.programming.cheatsheets.threads;

public class BookerThread extends Thread {
    private SimpleBooker _booker;

    public BookerThread(SimpleBooker booker) {
        this._booker = booker;
    }

    @Override
    public void run() {
        try {
            this._booker.book();
            this._booker.book();
            this._booker.book();
            this._booker.book();
            this._booker.book();
            this._booker.book();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
