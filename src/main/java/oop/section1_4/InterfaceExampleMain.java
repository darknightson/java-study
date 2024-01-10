package oop.section1_4;

public class InterfaceExampleMain {

    public static void main(String[] args) {
        SomeInterface someInterface = new ImplementsClass();
        AnotherInterface anotherInterface = new ImplementsClass();

        someInterface.someMethod();
        anotherInterface.anotherMethod();
        someInterface.defaultMethod();


    }
}
