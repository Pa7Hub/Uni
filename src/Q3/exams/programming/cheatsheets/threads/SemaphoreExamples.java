package Q3.exams.programming.cheatsheets.threads;

/**
 * Mit der Semaphore können unterschiedliche Dinge umgesetzt werden:
 */
public class SemaphoreExamples {
    private static Semaphor _mutex = new Semaphor(1);

    public static void main(String[] args) {
        /*
            Mutex:
                Mutual Exclusion. Wenn ein Thread bereits auf die Ressoruce zugreift, so kann kein anderer
                Thread ebenfalls Zugriff erlangen. Erst, wenn der erste Thread fertig ist, kann auch
                ein anderen Thread wieder zugreifen.
         */
        doSomethingThatRequiresMutexAccess(); // call the method and gain Mutex access. IF Mutex is already acquired by another Thread A, Thread B will be sent into WAITING.

        /*
            Queue:
                Warteschlange. Die Semaphore wird mit dem Counter Wert 0 initialisiert. Threads können dann über acquire() in den WAITING
                Zustand gehen. Über eine externe Anwendung kann dann mit release() ein Zugang freigegeben werden, sodass ein zufälliger
                Thread eingelassen wird.
         */
    }

    public static void doSomethingThatRequiresMutexAccess() {
        try {
            _mutex.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // DO SOMETHING NOW THAT YOU HAVE MUTEX ACCESS

        _mutex.release();
    }
}
