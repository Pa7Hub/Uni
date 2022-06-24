package Q3.programming.hue16;

public class Hotel {
	private final int numberOfRooms;
	private int bookedRoomsCounter;
	private final String name;

	public Hotel(int capacity, String name) {
		this.numberOfRooms = capacity;
		this.bookedRoomsCounter = 0;
		this.name = name;
	}

	// FIXME is this how we want it? If the booking part is not in the else part, then getting out of wait will initiate a booking. This means that if 2 threads are in state "wait"
	//  then notifying them will trigger 2 bookings, even tho there might only be 1 space available. This prevents that, but also makes it so (if unlucky) one agency might just never book/cancel
	public synchronized void book() {
		if (getNumberOfBookings() >= this.numberOfRooms) {
			System.out.println("Tried to book on full Hotel!");
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			this.bookedRoomsCounter++;
			this.notifyAll();
		}
	}

	// FIXME see above
	public synchronized void cancel() {
		// we have to check for smaller/equals 0 here because if a cancel does come through, its no longer == 0 and just never stops canceling :D
		if (getNumberOfBookings() <= 0) {
			System.out.println("Tried to cancel on empty Hotel!");
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			this.bookedRoomsCounter--;
			this.notifyAll();
		}
	}

	public int getNumberOfBookings() {
		return this.bookedRoomsCounter;
	}

	public String toString() {
		return this.name + " (" + this.bookedRoomsCounter + " von " + this.numberOfRooms + " gebucht)";
	}
}
