package Q3.programming.hue15;

import java.util.Random;

public class Airplane {
    Integer _occupied; // seats that are already occupied

    public Airplane() {
        this._occupied = 0;
    }

    public synchronized void book() {
        int rand = new Random().nextInt();
        this._occupied++;
    }

    public Integer getOccupiedSeats() {
        return this._occupied;
    }

    public void resetOccupiedSeats() {
        this._occupied = 0;
    }
}
