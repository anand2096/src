package LLD;
public class Synchronization {
    public static void main(String[] a) {
        Counter c = new Counter();
        Thread t1 = new Thread(() -> {
            c.increment();
        });
        Thread t2 = new Thread(() -> {
            c.decrement();
        });
        long start = System.currentTimeMillis();
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println((end-start));

    }
    static class Counter2 {
        int value = 0;

        synchronized void increment() {

            for (int i = 0; i < 10000000; i++) {
                value++;
            }
        }

        synchronized void decrement() {

            for (int i = 0; i < 10000000; i++) {
                value--;
            }
        }
    }
    static class Counter {
        int value = 0;

        void increment() {
            for (int i = 0; i < 10000000; i++) {
                synchronized(this) {
                    value++;
                }
            }
        }

        void decrement() {
            for (int i = 0; i < 10000000; i++) {
                synchronized(this) {
                    value--;
                }
            }
        }
    }
}