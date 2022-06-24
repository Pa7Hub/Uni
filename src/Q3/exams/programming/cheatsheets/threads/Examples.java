package Q3.exams.programming.cheatsheets.threads;

import org.junit.jupiter.api.Test;

/**
 * Die jeweiligen Methoden können ausgeführt werden, um den Code mal laufen zu sehen
 */
public class Examples {

    @Test
    void threadExample() {
        ExampleThread1 thread1 = new ExampleThread1("A");
        thread1.start();
        // Expected output: "Thread A has been created"
    }

    @Test
    void runnableImplementation() {
        // Wir erstellen erst ein Thread, dem wir dann das Runnable Objekt geben. Der Thread führt dann die run() Methode des Runnables aus.
        new Thread(new ExampleRunnable(), "ExampleThread1").start();
        // Expected output: "Runnable has been called"
    }

    /**
     * Auf einem Konto kann ein Betrag ein- und ausgezahlt werden. Über einen AccountManagerThread kann auf ein Konto zugegriffen werden.
     * In diesem Fall ist die Konto Klasse nicht synchronized und man sieht, dass der Kontostand komplett zufällig ist.
     */
    @Test
    void unsynchronizedAccess() {
        Account account = new Account(120);
        AccountManagerThread thread1 = new AccountManagerThread(account, "deposit");
        AccountManagerThread thread2 = new AccountManagerThread(account, "withdraw");
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Account balance: " + thread1.getAccount().getBalance());
    }

    /**
     * Nachdem die Methoden des Account Objekts mit synchronized ergänzt wurden, ist der Kontostand stets gleich. Wenn mehrere Threads auf eine Ressource zugreifen können, so nennt man den Bereich
     * den kritischen Bereich. Da dort mehrere Threads gleichzeitig drauf zugreifen, können unbeabsichtigte Nebeneffekte auftreten. Über Synchronized erhält ein Thread den "monitor" und hält diesen,
     * bis er in der Anwendung fertig ist. Dann gibt er den monitor wieder frei. Alle anderen Threads, die versuchen auf das Programm zuzugreifen, während der monitor bereits von einem anderen Thread
     * genutzt wird, werden geblockt und erst wieder aufgeweckt, wenn der monitor frei ist. Dadurch führt erst thread1 seine Einzahlungen aus und dann thread2 seine Auszahlungen.
     * In Lifecycle.jpg sieht man, dass der Thread sich bei warten auf den monitor im Zustand BLOCKED befindet.
     */
    @Test
    void synchronizedAccess() {
        SyncAccount account = new SyncAccount(120);
        SyncAccountManagerThread thread1 = new SyncAccountManagerThread(account, "deposit");
        SyncAccountManagerThread thread2 = new SyncAccountManagerThread(account, "withdraw");
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Account balance: " + thread1.getAccount().getBalance());
    }

    /**
     * Ein Thread kann auch über wait() in einen Wartezustand versetzt werden. Befindet sich ein Thread im Zustand WAITING, so kann er nur über notify() oder notifyAll() geweckt werden.
     * Am besten würde man sowas mit einer UI sehen, aber ich kenne mich damit so garnicht aus. Sorry.
     * Wenn man die ganzen Zustände nochmal sehr gut sehen will, dann guckt euch am besten die Lösung für hue16 an, da kann über die UI direkt der Zustand gesehen werden.
     * Wichtig hierbei ist einfach nur, dass wir über notify() nicht bestimmen können, welchen thread wir wecken. Über notifyAll() würden alle Threads geweckt werden, was aber auch unerwünscht sein kann.
     * In SimpleBooker sind nochmal einige Kommentare.
     */
    @Test
    void waitAndNotify() {
        SimpleBooker booker = new SimpleBooker();
        BookerThread thread = new BookerThread(booker);
        BookerThread thread2 = new BookerThread(booker);
        thread.start();
        thread2.start();

        // Thread2 sollte in Zustand WAITING sein.
        System.out.println("Thread state: " + thread.getState());
        System.out.println("Thread state: " + thread2.getState());
    }

    /**
     * Funktioniert leider nicht als Test, daher unter DeadlockExample.java
     */
    @Test
    void deadlockExample() {
    }

    /**
     * Ein livelock ist ein Fall, indem Threads nicht aufeinander warten, sondern dauernd Zustände wechseln und dadurch "nichts erreichen".
     * Für die Hotelaufgabe aus den Vorlesungen hatte ich ja bereits mal ein Beispiel für einen "Fallback" beschrieben und angemerkt, dass das in einem Livelock resultieren würde.
     * Bei dem Fallback würde, sobald von 10 Threads bereits 9 im WAITING Zustand sind, der 10te alle anderen Aufwecken. Die würden dann alle wieder in WAITING gehen, bis der letzte sie wieder aufweckt.
     * Das wird nie enden. Und zugleich nix erreichen. Ein Livelock ist also eine Situation, in der Threads ihre Aufgabe nicht ausführen können, gleichzeitig aber nie enden.
     */
    @Test
    void livelockExample() {
        // Falls unverständlich kann ich ein Beispiel noch schreiben
    }


}