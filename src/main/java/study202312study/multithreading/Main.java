package study202312study.multithreading;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
        });

        thread.setName("anthony thread");

        System.out.println("wh are in thread = " + Thread.currentThread().getName() + " before starting a new thread");
        thread.start();
        System.out.println("wh are in thread = " + Thread.currentThread().getName() + " after starting a new thread");
        Thread.sleep(10000);
    }
}
