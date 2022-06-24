package Q3.programming.hue16.UI;

import Q3.programming.hue16.Hotel;
import Q3.programming.hue16.RunnableAdapter;
import Q3.programming.hue16.ThreadStateUpdater;

import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * A visual class showing the states of all threads and all hotels
 */
public abstract class TravelCenter extends JFrame {

	private static final long serialVersionUID = 1L;

	// -- ui elements --
	private JPanel jContentPane = null;
	private JTextArea jTextAreaHotels = null;
	private JTextArea jTextAreaAgencies = null;
	private JButton jButtonInterrupt = null;

	private ThreadStateUpdater threadStateUpdater = null;

	/**
	 * List of hotels
	 */
	private List<Hotel> hotels = new ArrayList<Hotel>();

	/**
	 * List of Runnables
	 * (which are Travel Agencies booking or cancelling seats on the hotels)
	 */
	private List<RunnableAdapter> runnables = new ArrayList<RunnableAdapter>();



	/**
	 * Konstruktor mit Start der Anwendung
	 * @param string der Fenstertitel
	 */
	public TravelCenter(String string) {
		super();
		this.initialize(string);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	private void initialize(String title) {
		this.setSize(640, 320);
		this.setContentPane(getJContentPane());
		this.setTitle(title);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				// ACHTUNG: JVM wird hier hart beendet. Es erfolgt kein sauberer Abbruch der Threads!
				// Dazu k�nnte interruptAll() verwendet werden + warten bis alle Threads beendet wird.
				// Dies erfordert jedoch eine weitere Behandlung f�r den Fall,
				// dass die Unterbrechungsaufforderung ignoriert wird.
				System.exit(0);
			}
		});
		this.hotels = this.createHotels();
		this.runnables = this.createRunnables();
		this.threadStateUpdater = new ThreadStateUpdater(this);
		this.threadStateUpdater.start();
		this.runnables.forEach(RunnableAdapter::start);
	}

	/**
	 * Create the list of hotels here!
	 * <xmp>e.g. new Hotel(capacity,name)</xmp>
	 * @return
	 */
	protected abstract List<Hotel> createHotels();

	/**
	 * Create the runnable booking agencies here!
	 * <xmp>e.g. new <Your Class>(this.hotels, name)</xmp>
	 * @return
	 */
	protected abstract List<RunnableAdapter> createRunnables();

	/**
	 * Send interrupt-request to all bookien agency threads.
	 */
	private void interruptAll() {
		for (RunnableAdapter current : this.runnables)
			current.interrupt();
	}

	// -- update information shown in ui elements --

	/**
	 * Updates the states of all threads and all hotels
	 */
	public synchronized void update() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				updateHotelList();
				updateThreadStates();
			}
		});
	}

	private void updateThreadStates() {
		if (this.runnables.isEmpty()) {
			this.jTextAreaAgencies.setText("No threads defined");
		} else {
			final StringBuilder text = new StringBuilder();
			for (RunnableAdapter r : this.runnables) {
				text.append(r.toString() + " (" + r.getStateString() + ")");
				text.append(System.lineSeparator());
			}
			this.jTextAreaAgencies.setText(text.toString());
		}
	}

	private void updateHotelList() {
		if (this.hotels.isEmpty()) {
			this.jTextAreaHotels.setText("No hotels defined");
		} else {
			final StringBuilder text = new StringBuilder();
			for (Hotel p : this.hotels) {
				text.append(p.toString());
				text.append(System.lineSeparator());
			}
			this.jTextAreaHotels.setText(text.toString());
		}
	}

	// -- create ui elements --

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJTextAreaHotels(), null);
			jContentPane.add(getJTextAreaAgencies(), null);
			jContentPane.add(getJButtonInterrupt(), null);
		}
		return jContentPane;
	}

	private JTextArea getJTextAreaHotels() {
		if (jTextAreaHotels == null) {
			jTextAreaHotels = new JTextArea();
			jTextAreaHotels.setBounds(new Rectangle(20, 20, 280, 200));
			jTextAreaHotels.setEditable(false);
		}
		return jTextAreaHotels;
	}

	private JTextArea getJTextAreaAgencies() {
		if (jTextAreaAgencies == null) {
			jTextAreaAgencies = new JTextArea();
			jTextAreaAgencies.setBounds(new Rectangle(320, 20, 280, 200));
			jTextAreaAgencies.setEditable(false);
		}
		return jTextAreaAgencies;
	}

	private JButton getJButtonInterrupt() {
		if (jButtonInterrupt == null) {
			jButtonInterrupt = new JButton();
			jButtonInterrupt.setBounds(new Rectangle(320, 240, 100, 20));
			jButtonInterrupt.setText("Interrupt All");
			jButtonInterrupt.addActionListener(e -> interruptAll());
		}
		return jButtonInterrupt;
	}
}
