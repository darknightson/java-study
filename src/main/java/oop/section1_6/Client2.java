package oop.section1_6;

public class Client2 {
    public void throwUnCheckedException() {
        throw new UnCheckedException();
    }
    public void tryCatchCheckedException() {
        try {
            throwUnCheckedException();
        } catch (UnCheckedException e) {
            e.printStackTrace();
        }
    }
}
