package Q3.exams.programming.cheatsheets.async;

import Q3.exams.programming.cheatsheets.threads.Semaphor;

/**
 * Future sind die erste Einführung von Async Operations. Bisher haben wir immer synced gecoded,
 * sprich, wir haben immer auf die Antwort einer Operation, eines Programms oder einer Schnittstelle gewartet.
 * Bei Async ist das genau umgekehrt. Wir nutzen eine Methode, ohne dabei zu wissen, ob und wann wir etwas
 * zurück kriegen werden. Das macht die Nebenläufigkeit von Programmen deutlich besser, hat aber auch seine
 * eigenen Downsides.
 *
 * In einem Future Objekt kann ein Inhalt (_contents) enthalten sein. Wenn ein Future Objekt initialisiert wird,
 * dann kann es entweder Contents besitzen, oder nicht. Möchte ein anderes Objekt jetzt wissen, ob tatsächlich ein
 * Inhalt vorhanden ist, so kann er dies über getContents() überprüfen.
 *
 */
public class Future<T> {
   private T _contents;
   private Semaphor _signal;

   public Future() {
       this._signal = new Semaphor(0);
   }

   public void receiveContents(T contents) {
       this._contents = contents;
       this._signal.release();
   }

   public T getContents() throws InterruptedException {
       while (this._contents == null) this._signal.acquire(); // if no contents, then wait until someone pushes them
       return this._contents;
   }
}
