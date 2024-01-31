package concurrency;

import java.net.URI;
import java.net.URL;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {
    // write your code here

    private final Semaphore sem_1;
    private final Semaphore sem_2;
    private final Semaphore sem_3;

    private AtomicInteger cnt;

    public Solution(int n) {
        // write your code here
        this.sem_1 = new Semaphore(1);
        this.sem_2 = new Semaphore(0);
        this.sem_3 = new Semaphore(0);
        this.cnt = new AtomicInteger(n);
    }

    public void printA() throws InterruptedException {
        // write your code here
        sem_1.acquire();
        System.out.println("ABC" + "by" + Thread.currentThread().getName());
        cnt.decrementAndGet();
        sem_2.release();
    }

    public void printB() throws InterruptedException {
        // write your code here
        sem_2.acquire();
        System.out.println("ABC" + "by" + Thread.currentThread().getName());
        cnt.decrementAndGet();
        sem_3.release();
    }

    public void printC() throws InterruptedException {
        // write your code here
        sem_3.acquire();
        System.out.println("ABC" + "by" + Thread.currentThread().getName());
        cnt.decrementAndGet();
        sem_1.release();
    }

    public int getCnt() {
        return cnt.get();
    }

    public static void main(String[] args) throws Exception {

        URI url1=new URI("abcd");
        String inp = "tunnel/praveer-cpacs";
        System.out.println("INP" + inp.substring(inp.indexOf("/") + 1));
        // Fetching Host name  from given url
        System.out.println("The given url is : "+url1);
        int idx = url1.getHost().indexOf(".");
        System.out.println("Host name in given url is : "+url1.getHost().substring(0, idx));

        Solution sol = new Solution(5);

        new Thread(() -> {
            try {
                while(sol.getCnt() > 0) {
                    sol.printA();
                }
            } catch (InterruptedException e) {

            }
        }, "T1").start();

        new Thread(() -> {
            try {
                while(sol.getCnt() > 0) {
                    sol.printB();
                }
            } catch (InterruptedException e) {

            }
        }, "T2").start();

        new Thread(() -> {
            try {
                while(sol.getCnt() > 0) {
                    sol.printC();
                }
            } catch (InterruptedException e) {

            }
        }, "T3").start();

    }
}