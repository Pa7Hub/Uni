package Q3.programming.hue16;

import Q3.programming.hue16.UI.TravelCenter;

public class ThreadStateUpdater extends Thread {
	private TravelCenter travelCenter;
	private int interval;

	public ThreadStateUpdater(TravelCenter travelCenter, int interval) {
		super();
		this.travelCenter = travelCenter;
		this.interval = interval;
	}

	public ThreadStateUpdater(TravelCenter travelCenter) {
		this(travelCenter, 500);
	}

	public void run() {
		while (!this.isInterrupted()) {
			this.travelCenter.update();
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				this.interrupt();
			}
		}
	}
}
