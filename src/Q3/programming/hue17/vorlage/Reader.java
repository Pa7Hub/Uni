package Q3.programming.hue17.vorlage;

/**
 * Einfacher Leseprozess.
 *
 * @author ck
 */
public class Reader extends RWProcess {
	public Reader(AccessManager accessManager, String name) {
		super(accessManager, name);
	}

	public Resource startAction() throws InterruptedException {
		return this.getAccessManager().startReading();
	}

	public void stopAction() throws InterruptedException {
		this.getAccessManager().stopReading();
	}

	public void action(Resource r) {
		System.out.println(this.toString() + ": Liest " + r.get() + ".");
	}
}
