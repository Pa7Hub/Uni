package Q3.programming.hue15;

public class Deadlock {
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