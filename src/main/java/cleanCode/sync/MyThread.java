package cleanCode.sync;

public class MyThread implements Runnable {

    @Override
    public void run() {
        X x = new X();
        x.getLastIdUsed();;
//        for ( int i=0; i<100; i++) {
//            System.out.println(Thread.currentThread().getName() + " : " + i );
//        }
    }
}
