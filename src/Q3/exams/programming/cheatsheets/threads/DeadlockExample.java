package Q3.exams.programming.cheatsheets.threads;

/**
 * LÄUFT, BIS MAN IHN UNTERBRICHT!!!
 *
 * Deadlock entsteht, wenn zwei Threads in einen Wartezustand geraten, bei dem sie auf den anderen Thread warten.
 * Da sich die Threads nicht aufwecken und für immer aufeinander warten, "bleiben sie stehen", bzw. deadlocken.
 */
public class DeadlockExample {
    public static void main(String[] args) {
        final String res1 = "Dead";
        final String res2 = "lock";

        Thread thread1 = new Thread(){
            public void run() {
                synchronized(res1) {
                    System.out.println("Res1 is in Thread1");
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        System.out.println("zzz");
                    }
                    {}
                    synchronized (res2) {
                        System.out.println("Res2 is in Thread1");
                    }
                }

            }
        };

        Thread thread2 = new Thread() {
            public void run() {
                synchronized(res2) {
                    System.out.println("Res2 is in Thread2");
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        System.out.println("zzz");
                    }
                    {}
                    synchronized (res1) {
                        System.out.println("Res1 is in Thread2");
                    }
                }
            }
        };
        thread1.start();
        thread2.start();
    }
}