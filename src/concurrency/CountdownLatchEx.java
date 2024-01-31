package concurrency;

import java.util.concurrent.CountDownLatch;

public class CountdownLatchEx {

    private static class Worker implements Runnable {

        private String name;
        private int delay;
        private CountDownLatch latch;

        public Worker(String name, int delay, CountDownLatch latch) {
            this.name = name;
            this.delay = delay;
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                // ignore
            }
            System.out.println("Worker " + name + " finished");
            latch.countDown();
        }

    }

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(2);

        Worker w1 = new Worker("W-1", 1000, latch);
        Worker w2 = new Worker("W-2", 1000, latch);
        Worker w3 = new Worker("W-3", 1000, latch);

        Thread t1 = new Thread(w1, "T1");
        t1.start();
        Thread t2 = new Thread(w2, "T2");
        t2.start();
        Thread t3 = new Thread(w3, "T3");
        t3.start();

        System.out.println("Latch count " + latch.getCount());
        latch.await();
        System.out.println("Latch count " + latch.getCount());

        System.out.println("Main thread finished");
    }

}
