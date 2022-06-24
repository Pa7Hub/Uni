package Q3.programming.hue16.TravelAgencies;

import Q3.programming.hue16.Hotel;

import java.util.List;
import java.util.Random;

public class TravelAgencyC extends TravelAgency {
    public TravelAgencyC(List<Hotel> hotels, String name) {
        super(hotels, name);
    }

    @Override
    public void book() {
        try {
            this.getRandomHotel().book();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cancel() {
        try {
            this.getRandomHotel().cancel();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        System.out.println("TravelAgencyC has been started!");
        while(!this.isInterrupted()) {
            if (new Random().nextInt() % 8 == 0) { // lower chance to cancel a booking
                this.book();
            } else {
                this.cancel();
            }
        }
    }
}
