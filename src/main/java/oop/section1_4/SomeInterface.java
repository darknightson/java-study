package oop.section1_4;

public interface SomeInterface {

    public static final String name = "cat";

    void someMethod();

    default void defaultMethod() {
        System.out.println("default method");
    }
}
