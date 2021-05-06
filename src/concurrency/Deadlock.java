package concurrency;

public class Deadlock {

    private static class A {

    }

    private static class B {}

    public static void main(String[] args) {
        A a = new A();
        B b = new B();

        Runnable aBlock = () -> {
            synchronized (a) {
                System.out.println("Holding A");

                synchronized (b) {
                    System.out.println("Trying B");
                }
            }
        };

        Runnable bBlock = () -> {
            synchronized (b) {
                System.out.println("Holding B");

                synchronized (a) {
                    System.out.println("Trying A");
                }
            }
        };

        new Thread(aBlock).start();
        new Thread(bBlock).start();

    }

}
