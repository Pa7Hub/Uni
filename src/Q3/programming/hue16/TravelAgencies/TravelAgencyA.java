package Q3.programming.hue16.TravelAgencies;

import Q3.programming.hue16.Hotel;

import java.util.List;

public class TravelAgencyA extends TravelAgency {

    public TravelAgencyA(List<Hotel> hotels, String name) {
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
        // do nothing
    }

    @Override
    public void run() {
        System.out.println("TravelAgencyA has been started!");
        while (!this.isInterrupted()) {
            this.book();
        }
    }
}