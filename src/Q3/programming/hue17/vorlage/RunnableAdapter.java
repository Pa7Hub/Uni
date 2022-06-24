package Q3.programming.hue17.vorlage;

import java.util.Random;

public abstract class RunnableAdapter implements Runnable {

	private Thread whereIRunIn;

	public RunnableAdapter() {
		super();
	}

	public void start() {
		this.whereIRunIn = new Thread(this);
		this.whereIRunIn.start();
	}

	public void delayUpTo(int millis) {
		try {
			Thread.sleep(new Random().nextInt(millis));
		} catch (InterruptedException e) {
			this.interrupt();
		}
	}

	public void interrupt() {
		this.whereIRunIn.interrupt();
	}

	public boolean isInterrupted() {
		return this.whereIRunIn.isInterrupted();
	}

}
