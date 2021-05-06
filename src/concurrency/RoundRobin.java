package concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class Worker implements Runnable {

    private Worker next;
    private BlockingQueue<Integer> bq = new LinkedBlockingQueue<>();

    public void setNext(Worker w) {
        this.next = w;
    }

    public void accept(int i) {
        bq.offer(i);
    }

    @Override
    public void run() {
        try {
            while(true) {
                int x = bq.take();
                System.out.println(x + " by " + Thread.currentThread().getName());
                Thread.sleep(5000);
                next.accept(x + 1);
            }
        } catch(InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

public class RoundRobin {

    public static void main(String[] args) {

        Worker w1 = new Worker();
        Worker w2 = new Worker();
        Worker w3 = new Worker();

        w1.setNext(w2);
        w2.setNext(w3);
        w3.setNext(w1);

        Thread t1 = new Thread(w1, "1");
        Thread t2 = new Thread(w2, "2");
        Thread t3 = new Thread(w3, "3");

        t3.start();
        t1.start();
        t2.start();

        w1.accept(1);
    }

}
