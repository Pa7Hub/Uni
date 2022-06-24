package Q3.exams.programming.cheatsheets.threads;

/**
 * Ein Thread Objekt, welches zum Ausführen von Code genutzt werden kann. Der Thread Lifecycle kann in der Datei Lifecycle.jpg gesehen werden.
 * Beispiele für die Lifecycle States sind in den tests enthalten, das hier ist nur eine Beispiel Thread Klasse.
 */
public class ExampleThread1 extends Thread {
    private String _name;

    public ExampleThread1(String name) {
        this._name = name;
    }

    @Override
    public void run() {
        System.out.println("Thread " + this._name + " has been created");
    }
}
