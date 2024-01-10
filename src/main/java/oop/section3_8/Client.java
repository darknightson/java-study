package oop.section3_8;

public class Client {
    private final SomeInterface someInterface;

    public Client(SomeInterface someInterface) {
        this.someInterface = someInterface;
    }

    public void doSomething() {
        someInterface.someMethod();
    }
}
