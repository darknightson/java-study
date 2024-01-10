package oop.section3_2;

public class Child extends Parent {

    public void test() {
        super.someMethod(-1);
    }

    @Override
    public void someMethod(int input) {
        if ( input < 0 ) {
            throw new IllegalArgumentException("input must be positive");
        }
        System.out.println("child input = " + input);
    }
    public void childMethod() {
        System.out.println("childMethod");
    }
}
