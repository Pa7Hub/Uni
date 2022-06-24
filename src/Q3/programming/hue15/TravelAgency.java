package Q3.programming.hue15;

public class TravelAgency extends Thread {
    Airplane _airplane;
    Integer _bookingNbr;

    public TravelAgency(Airplane airplane, Integer bookingNbr) {
        this._airplane = airplane;
        this._bookingNbr = bookingNbr;
    }


    public void run() {
        System.out.println("started thread");
    }

    public void book() {
        for (int i = 0; i < _bookingNbr; i++) {
            _airplane.book();
        }
    }
}
