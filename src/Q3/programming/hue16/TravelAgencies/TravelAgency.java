package Q3.programming.hue16.TravelAgencies;

import Q3.programming.hue16.Hotel;
import Q3.programming.hue16.RunnableAdapter;

import java.util.List;
import java.util.Random;

public abstract class TravelAgency extends RunnableAdapter {
    private List<Hotel> _hotels;
    private String _name;

    public TravelAgency(List<Hotel> hotels, String name) {
        super();
        _hotels = hotels;
        _name = name;
    }

    public void addHotel(Hotel hotel) {
        this._hotels.add(hotel);
        System.out.println("Added new Hotel");
    }

    public abstract void book();

    public abstract void cancel();

    public Hotel getRandomHotel() throws Exception {
        // TODO add own Exception
        // TODO or rather just do it optional
        if (this._hotels.size() == 0) throw new Exception("Cannot get random hotel from empty hotel list!");
        int max = this._hotels.size();
        int val = new Random().nextInt(max); // getting 0 here shouldn't matter
        return this._hotels.get(val);
    }

    @Override
    public String toString() {
        return this._name;
    }


}
