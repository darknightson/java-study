package oop;

public class AbstractClient extends AbstractClassT {

    public AbstractClient(String username) {
        super(username);
    }

    @Override
    public void someMethod() {
        System.out.println("AbstractClient.someMethod()");
    }
}
