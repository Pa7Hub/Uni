package Q3.exams.programming.cheatsheets.threads;

/**
 * Own Semaphore class according to Skript
 *
 * Die von Herrn Köpp vorgestellte Version einer Semaphore hat einen internen counter, der angibt, wie viele Prozesse noch auf die Ressource
 * über die Semaphore zugreifen können. Wird über acquire() ein Permit für die Ressource gegeben, so wird der counter dekrementiert.
 * Falls keine Permits verfügbar sind, so wird der Thread in den WAIT Zustand gesetzt und erst wieder aufgeweckt, wenn über release()
 * ein anderer Thread einen Permit freigibt.
 */
public class Semaphor {
    private Integer _count;

    public Semaphor(Integer count) {
        this._count = count;
    }

    // up
    public synchronized void release() {
        this._count++;
        notify();
    }

    // down
    public synchronized void acquire() throws InterruptedException {
        while (this._count == 0) {
            wait();
        }
        this._count--;
    }
}
