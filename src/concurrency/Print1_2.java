package concurrency;

import java.util.concurrent.Semaphore;

public class Print1_2 {

    private Semaphore sem_1 = new Semaphore(1);

    private Semaphore sem_2 = new Semaphore(0);

    void printOne() {
        try {
            sem_1.acquire();
            System.out.println("1" + "(" + Thread.currentThread().getName() + ")");
            Thread.sleep(3000);
        } catch(InterruptedException ex) {

        }
        sem_2.release();
    }

    void printTwo() {
        try {
            sem_2.acquire();
            System.out.println("2" + "(" + Thread.currentThread().getName() + ")");
            Thread.sleep(3000);
        } catch(InterruptedException ex) {

        }
        sem_1.release();
    }

    public static void main(String[] args) {
        Print1_2 printer = new Print1_2();
        new Thread(() -> {
            while(true) {
                printer.printOne();
            }
        }, "T1").start();

        new Thread(() -> {
            while(true) {
                printer.printTwo();
            }
        }, "T2").start();
    }

}
