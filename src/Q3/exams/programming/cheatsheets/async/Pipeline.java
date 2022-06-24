package Q3.exams.programming.cheatsheets.async;

import Q3.exams.programming.cheatsheets.threads.Semaphor;

import java.util.ArrayList;
import java.util.List;

/**
 * Code copied from Köpps Script.
 *
 * Pipelines sind eine weitere Einführung in Asynchrone Operationen.
 * Ein Thread kann Daten in die Pipeline über push(element) pushen und darüber ggf.
 * wartende Threads wecken, die dann über pop() das neuste Element erhalten.
 *
 * Das Prinzip ist eigentlich relativ straight forward. Pipelines mit der Capacity = 1
 * sind ein Future Objekt.
 */
public class Pipeline <T> {
    private List<T> _data;
    private Semaphor _usedSpace;
    private Semaphor _freeSpace;
    private Semaphor _mutex;

    public Pipeline(Integer capacity) {
        this._data = new ArrayList<T>();
        this._usedSpace = new Semaphor(0);
        this._freeSpace = new Semaphor(capacity);
        this._mutex = new Semaphor(1);
    }

    public T pop() throws InterruptedException {
        T result = null;
        this._usedSpace.acquire();
        try {
            this._mutex.acquire();
            result = this._data.remove(0);
            this._mutex.release();
            this._freeSpace.release();
        } catch (InterruptedException ie) {
            this._usedSpace.release();
            throw ie;
        }
        return result;
    }

    public void push(T element) throws InterruptedException {
        this._freeSpace.acquire();
        try {
            this._mutex.acquire();
            this._data.add(element);
            this._mutex.release();
            this._usedSpace.release();
        } catch (InterruptedException ie) {
            this._freeSpace.release();
            throw ie;
        }
    }
}
