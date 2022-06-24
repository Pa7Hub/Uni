package Q3.programming.hue17.vorlage;

/**
 * Ein einfacher Prozess mit einem durch einen {@link AccessManager} verwalteten
 * Zugriff auf eine Ressource.
 *
 * @author ck
 */
public abstract class RWProcess extends RunnableAdapter {

	/**
	 * Prozessname (Ohne besondere fachliche Funktion)
	 */
	private final String name;

	/**
	 * AccessManager-Instanz zur Verwaltung der Ressourcenzugriffe.
	 */
	private final AccessManager accessManager;

	public RWProcess(AccessManager accessManager, String name) {
		this.accessManager = accessManager;
		this.name = name;
	}

	AccessManager getAccessManager() {
		return this.accessManager;
	}

	/**
	 * Wiederholte Ausf�hrung von Aktion auf Ressource.
	 * <p>
	 * <b>WARNUNG:</b> Bei Unterbrechungsaufforderung erfolgt <b>keine</b>
	 * zuverl�ssige Freigabe des Ressourcenzugriffs!
	 * </p>
	 * <p>
	 * Zugriff anfordern - nutzen - beenden. Ausf�hrung k�nstlich verz�gert.
	 * </p>
	 */
	public void run() {
		try {
			while (!this.isInterrupted()) {
				Resource r = this.startAction();
				this.delay();
				this.action(r);
				this.delay();
				this.stopAction();
				this.delay();
			}
		} catch (InterruptedException ie) {
			System.out.println(this.toString() + ": Interrupt beim Warten.");
			this.interrupt();
		}
		System.out.println(this.toString() + ": Ende.");
	}

	/**
	 * Zugriff auf Ressource anfordern.
	 *
	 * @return die angeforderte Ressource
	 * @throws InterruptedException
	 */
	public abstract Resource startAction() throws InterruptedException;

	/**
	 * Zugriff auf Ressource nutzen.
	 *
	 * @param r
	 */
	public abstract void action(Resource r);

	/**
	 * Zugriff auf Ressource beenden.
	 *
	 * @throws InterruptedException
	 */
	public abstract void stopAction() throws InterruptedException;

	@Override
	public String toString() {
		return this.name;
	}

	/**
	 * Kurze zuf�llige k�nstliche Wartezeit.
	 * <p>
	 * F�r bessere Sichtbarkeit nebenl�ufiger Effekte.
	 * </p>
	 */
	private void delay() throws InterruptedException {
		delayUpTo(10);
	}
}
