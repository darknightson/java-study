package oop;

public class Child extends Parent {
    public void anotherMethod() {
        System.out.println("Child.someMethod()");
    }

    @Override
    public void someMethod() {
        System.out.println(" chiled someMethod()");
    }
}
