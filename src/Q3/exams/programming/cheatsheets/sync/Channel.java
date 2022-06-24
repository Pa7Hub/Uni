package Q3.exams.programming.cheatsheets.sync;

import Q3.exams.programming.cheatsheets.threads.Semaphor;

/**
 * Channels können für die synchrone Kommunikation zwischen einem Sender und Receiver genutzt werden.
 * In der Klasse Channel sieht man, dass wenn ein Sender eine Nachricht verschickt, diese von einem Receiver
 * angenommen werden muss. Falls dies nicht passiert, so bleibt der Sender "busy". Dadurch wird garantiert,
 * dass die Kommunikation synchron ist.
 *
 * In der Vorlesung haben wir die Channels hauptsächlich für das Versenden von Operationen genutzt,
 * sodass von einer Klasse direkt Operationen an einen Receiver gesendet werden können, der dann damit was ausführt.
 *
 * Die Code Implementierung hier ist relativ easy. Ein Sender Objekt sendet über channel.send(D data) eine Nachricht, die dann
 * von einem Receiver Objekt angenommen wird. Das sollte aber aus der Klasse hier klar genug sein.
 */
public class Channel<D> {
    private D _data;
    private Semaphor _senderMutex = new Semaphor(0);
    private Semaphor _receiverMutex = new Semaphor(0);

    public void send(D data) throws InterruptedException {
        this._data = data;
        this._receiverMutex.release();
        this._senderMutex.acquire();
    }

    public D receive() throws InterruptedException {
        this._receiverMutex.acquire();
        D result = this._data;
        this._data = null;
        this._senderMutex.release();
        return result;
    }
}
