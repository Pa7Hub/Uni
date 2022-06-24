package Q3.programming.hue15;


import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // so uhm... turns out its always the expected amount? Dunno how that's supposed to be interpreted :D
        // I was expecting it to be random without synchronized. But oh well, apparently its not.
        benchmark2Threads(100, 100);
    }

    /**
     * Benchmark with 2 travel agencies booking on 1 plane at the same time
     * @param nbrOfBookings amount of bookings that a singular agency does for the plane
     * @param nbrOfRuns amount of runs that shall be completed for the benchmark
     */
    public static void benchmark2Threads(Integer nbrOfBookings, Integer nbrOfRuns) {
        long start = System.currentTimeMillis();
        Airplane plane = new Airplane();
        List<Integer> results = new ArrayList<>();
        TravelAgency agency1 = new TravelAgency(plane, nbrOfBookings);
        TravelAgency agency2 = new TravelAgency(plane, nbrOfBookings);
        agency1.start();
        agency2.start();
        for (int i = 0; i <= nbrOfRuns; i++) {
            agency1.book();
            agency2.book();
            results.add(plane.getOccupiedSeats());
            plane.resetOccupiedSeats();
        }
        // skip first 50
        for(int i = 49; i < nbrOfRuns; i++) {
            System.out.println("Run " + (i+1) + ": \t" + results.get(i));
        }
        long runtime = (System.currentTimeMillis() - start) / 1000;
        System.out.println("\nFinished " + nbrOfRuns + " runs in " + runtime + "s");
    }
}