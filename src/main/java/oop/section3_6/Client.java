package oop.section3_6;

public class Client {
    public static void main(String[] args) {
        Target target = new Adapter220V(new Adaptee100v());
        target.request();
    }
}


/*
퍼사드 패턴
 */