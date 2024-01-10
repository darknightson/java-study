package oop.section3_6;

public class Adapter220V implements Target {

    private final Adaptee100v adaptee100v;

    public Adapter220V(Adaptee100v adaptee100v) {
        this.adaptee100v = adaptee100v;
    }

    @Override
    public void request() {
        adaptee100v.electricitySupply();
    }
}
