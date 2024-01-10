package oop.section1_4;

public class ImplementsClass implements SomeInterface, AnotherInterface {
    @Override
    public void someMethod() {
        System.out.println(name  + "some method");
    }
    @Override
    public void anotherMethod() {
        System.out.println(name + "another method");
    }
}
