package Q3.programming.hue16.TravelAgencies;

import Q3.programming.hue16.Hotel;

import java.util.List;

public class TravelAgencyB extends TravelAgency {
    public TravelAgencyB(List<Hotel> hotels, String name) {
        super(hotels, name);
    }

    @Override
    public void book() {
        // do nothing
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
        System.out.println("TravelAgencyB has been started!");
        while (!this.isInterrupted()) {
            this.cancel();
        }
    }
}
