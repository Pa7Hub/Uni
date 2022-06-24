package Q3.exams.programming.cheatsheets.threads;

/**
 * Ein Runnable Object ist kein Thread, sondern eine Instanz, die von einem Thread genutzt werden kann. Während wir mit einem Thread Object direkt ein Thread starten,
 * wird bei ausführen eines Runnable Objects kein Thread gestartet. Runnables haben die Methode run(), die dann von einem Thread executed werden kann.
 * Da Runnable ein Interface mit einer einzelnen Funktion ist, wird es auch "functional interface" genannt.
 */
public class ExampleRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Runnable has been called");
    }
}
