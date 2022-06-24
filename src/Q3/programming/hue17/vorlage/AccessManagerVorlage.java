package Q3.programming.hue17.vorlage;

public class AccessManagerVorlage implements AccessManager {

	/** Anzahl aktive Leser */
	private int activeReaders = 0;

	/** Anzahl wartende Leser */
	private int waitingReaders = 0;

	/** Anzahl aktive Schreiber */
	private int activeWriters = 0;

	/** Anzahl wartende Schreiber */
	private int waitingWriters = 0;

	// TODO ***AUFGABE*** mutex: Schutz interner Zustand

	// TODO ***AUFGABE*** readerQueue: Warteschlange f�r Leseprozesse

	// TODO ***AUFGABE*** writerQueue: Warteschlange f�r Schreibprozesse

	/** Die verwaltete Ressource */
	private final Resource resource = new Resource();

	@Override
	public Resource startWriting() throws InterruptedException {
		// TODO ***AUFGABE*** Strategie Implementieren
		return null;
	}

	@Override
	public Resource startReading() throws InterruptedException {
		// TODO ***AUFGABE*** Strategie Implementieren
		return null;
	}

	@Override
	public void stopWriting() throws InterruptedException {
		// TODO ***AUFGABE*** Strategie Implementieren
	}

	@Override
	public void stopReading() throws InterruptedException {
		// TODO ***AUFGABE*** Strategie Implementieren
	}

	// TODO ***AUFGABE*** Ggf. Hilfsfunktionen

	// TODO ***AUFGABE*** Nutzen zur Korrektheitspr�fung
	/**
	 * Pr�ft interneren Zustand, und gibt im Fehlerfall eine Meldung aus.
	 */
	private void checkResourceAccess() {
		if (this.activeWriters > 1 || (this.activeWriters == 1 && this.activeReaders > 0)
				|| this.waitingReaders + this.activeReaders > Main.NUMBER_OF_READERS
				|| this.waitingWriters + this.activeWriters > Main.NUMBER_OF_WRITERS
				|| this.waitingReaders + this.activeReaders < 0 || this.waitingWriters + this.activeWriters < 0) {
			System.err.println("Fataler Fehler, ");
			this.printNumbers();
		}
	}

	/**
	 * Ausgabe der Anzahl aktiver und wartender Prozesse (nach interner Z�hlung)
	 */
	private void printNumbers() {
		System.out.print("Wartende Schreiber = " + this.waitingWriters);
		System.out.print(", Aktive Schreiber = " + this.activeWriters);
		System.out.print(", Wartende Leser = " + this.waitingReaders);
		System.out.println(", Aktive Leser = " + this.activeReaders);
	}

}
