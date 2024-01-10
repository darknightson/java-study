package oop.section1_6;

public class Client {
    public void throwCheckedException() throws CheckedException
    {
        throw new CheckedException();
    }

    public void tryCatchCheckedException() {
        try {
            throwCheckedException();
        } catch (CheckedException e) {
            e.printStackTrace();
        }
    }
}
