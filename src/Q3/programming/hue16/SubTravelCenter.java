package Q3.programming.hue16;

import Q3.programming.hue16.TravelAgencies.TravelAgencyA;
import Q3.programming.hue16.TravelAgencies.TravelAgencyB;
import Q3.programming.hue16.TravelAgencies.TravelAgencyC;
import Q3.programming.hue16.UI.TravelCenter;

import java.util.ArrayList;
import java.util.List;

public class SubTravelCenter extends TravelCenter {
    List<Hotel> _hotels;
    List<RunnableAdapter> _agencies;

    public SubTravelCenter(String string) {
        super(string);
    }

    @Override
    protected List<Hotel> createHotels() {
        this._hotels =  new ArrayList<Hotel>();
        _hotels.add(new Hotel(10, "Hotel - 10"));
        _hotels.add(new Hotel(20, "Hotel - 20"));
        _hotels.add(new Hotel(40, "Hotel - 40"));
        _hotels.add(new Hotel(80, "Hotel - 80"));
        return this._hotels;
    }

    public List<Hotel> getHotels() {
        return this._hotels;
    }

    @Override
    protected List<RunnableAdapter> createRunnables() {
        this._agencies = new ArrayList<RunnableAdapter>();
        _agencies.add(new TravelAgencyA(this.getHotels(), "Travel Agency A"));
        _agencies.add(new TravelAgencyB(this.getHotels(), "Travel Agency B"));
        _agencies.add(new TravelAgencyC(this.getHotels(), "Travel Agency C"));
        return this._agencies;
    }
}
