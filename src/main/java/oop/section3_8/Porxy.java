package oop.section3_8;

public class Porxy implements SomeInterface {

    private final Service service;

    public Porxy() {
        this.service = new Service();
    }

    @Override
    public void someMethod() {
        System.out.println(" someMethod() before");
        service.someMethod();
        System.out.println(" someMethod() alfter");
    }
}
