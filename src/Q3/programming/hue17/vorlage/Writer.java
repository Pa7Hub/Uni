package Q3.programming.hue17.vorlage;

/**
 * Einfacher Schreibprozess.
 *
 * @author ck
 */
public class Writer extends RWProcess {
	public Writer(AccessManager accessManager, String name) {
		super(accessManager, name);
	}

	public Resource startAction() throws InterruptedException {
		return this.getAccessManager().startWriting();
	}

	public void stopAction() throws InterruptedException {
		this.getAccessManager().stopWriting();
	}

	/**
	 * Setzt die Ressource auf einen zuf�lligen Wert im Intervall [0;100[
	 */
	public void action(Resource r) {
		int newValue = (int) (Math.random() * 100);
		r.set(newValue);
		System.out.println(this.toString() + ": Schreibt " + newValue + ".");
	}
}
