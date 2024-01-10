package cleanCode.sync;

public class X {
    private int lastIdUsed;

    public void getLastIdUsed() {

        for ( int i=0; i<100; i++) {
            System.out.println("i = "+ Thread.currentThread().getName() + " : " + i );
        }

        ++lastIdUsed;
    }
}
