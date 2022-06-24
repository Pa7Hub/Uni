package Q3.programming.hue17.vorlage;

/**
 * Zugriffsverwaltung f�r eine Ressource.
 *
 * Es erfolgt eine Unterscheidung zwischen Lese- und Schreibzugriffen.
 *
 * <dl>
 * <dt>Gleichzeitiger Lesezugriff</dt>
 * <dd>(Reine) Lesezugriffe d�rfen gleichzeitig aus mehreren unabh�ngigen
 * Prozessen erfolgen.</dd>
 * <dt>Exklusiver Schreibzugriff</dt>
 * <dd>Zugriffe zum Schreiben d�rfen niemals zeitgleich mit beliebigen anderen
 * Zugriffen erfolgen</dd>
 * </dl>
 *
 * @author ck
 */
public interface AccessManager {

	/**
	 * Schreibzugriff auf Ressource anfordern.
	 *
	 * <p>
	 * Die Implementierung stellt sicher, dass <b>niemals</b> Schreibzugriff erteilt
	 * wird, so lange ein anderer noch irgendeinen Zugriff besitzt! D.h.: Erfolgt
	 * aktuell ein Lese- oder Schreibzugriff, so wird die Anforderung in eine
	 * Warteschlage f�r Schreibprozesse eingereiht.
	 * </p>
	 * <p>
	 * Falls derzeit kein anderer Zugriff besteht, so soll der Schreibzugriff sofort
	 * gew�hrt werden.
	 * </p>
	 *
	 * @return die Ressource zum Schreiben
	 * @throws InterruptedException
	 */
	Resource startWriting() throws InterruptedException;

	/**
	 * Lesezugriff auf Ressource anfordern.
	 *
	 * <p>
	 * Die Implementierung stellt sicher, dass <b>niemals</b> Lesezugriff erteilt
	 * wird, so lange ein anderer noch Schreibzugriff besitzt! D.h.: Erfolgt aktuell
	 * ein Schreibzugriff, so wird die Anforderung in eine Warteschlage f�r
	 * Leseprozesse eingereiht.
	 * </p>
	 *
	 * <p>
	 * Das Verhalten, wenn noch Prozesse auf Schreibzugriff warten (und noch
	 * Lesezugriffe erfolgen) ist abh�ngig von der umgesetzten Strategie.
	 * </p>
	 *
	 * <p>
	 * Falls ausschlie�lich andere Leseprozesse bereits Zugriff haben, so kann (und
	 * soll) diese Anforderung sofort gew�hrt werden.
	 * </p>
	 *
	 * @return die Ressource zum Lesen
	 * @throws InterruptedException
	 */
	Resource startReading() throws InterruptedException;

	/**
	 * Freigabe der Ressource nach Abschluss des Schreibvorgangs.
	 *
	 * <p>
	 * Ggf. werden andere noch wartende Prozesse nach Freigabe aufgeweckt.
	 * </p>
	 *
	 * @throws InterruptedException
	 */
	void stopWriting() throws InterruptedException;

	/**
	 * Freigabe der Ressource nach Abschluss des Lesevorgangs.
	 *
	 * <p>
	 * Ggf. werden andere noch wartende Prozesse nach Freigabe aufgeweckt.
	 * </p>
	 *
	 * @throws InterruptedException
	 */
	void stopReading() throws InterruptedException;

}