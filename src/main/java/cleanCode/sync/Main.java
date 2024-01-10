package cleanCode.sync;

public class Main {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        MyThread2 myThread2 = new MyThread2();
        Thread thread = new Thread(myThread);
        Thread thread2 = new Thread(myThread2);
        thread.start();
        thread2.start();
    }
}
