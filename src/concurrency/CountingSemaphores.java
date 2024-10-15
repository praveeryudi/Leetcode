package concurrency;

import java.util.concurrent.Semaphore;

public class CountingSemaphores {

    private static class SharedPrinter{

        private final Semaphore semOdd = new Semaphore(1);
        private final Semaphore semEven = new Semaphore(0);

        //Method for printing even numbers
        public void printEvenNum(int num){
            try {
                semEven.acquire();
                System.out.println(num + " by " + Thread.currentThread().getName());
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            semOdd.release();
        }

        //Method for printing odd numbers
        public void printOddNum(int num){
            try {
                semOdd.acquire();
                System.out.println(num + " by " + Thread.currentThread().getName());
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            semEven.release();
        }
    }

    private static class OddNumProducer implements Runnable {

        SharedPrinter sp;
        int limit;

        OddNumProducer(SharedPrinter sp, int limit) {
            this.sp = sp;
            this.limit = limit;
        }

        @Override
        public void run() {
            for(int i = 1; i <= limit; i += 2) {
                sp.printOddNum(i);
            }
        }
    }

    private static class EvenNumProducer implements Runnable {

        SharedPrinter sp;
        int limit;

        EvenNumProducer(SharedPrinter sp, int limit) {
            this.sp = sp;
            this.limit = limit;
        }

        @Override
        public void run() {
            for(int i = 2; i <= limit; i += 2) {
                sp.printEvenNum(i);
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("This is start of main thread");
        SharedPrinter sp = new SharedPrinter();
        Thread t1 = new Thread(new OddNumProducer(sp, 10), "OddTh");
        Thread t2 = new Thread(new EvenNumProducer(sp, 10), "EvenTh");

        t2.start();
        t1.start();

        try {
            t2.join();
            t1.join();
        } catch(InterruptedException e) {

        }

        System.out.println("This is end of main thread");
    }

}
