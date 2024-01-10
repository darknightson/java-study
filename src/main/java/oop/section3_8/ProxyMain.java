package oop.section3_8;

public class ProxyMain {

    public static void main(String[] args) {
        Client client = new Client(new Porxy());
        client.doSomething();
    }
}
