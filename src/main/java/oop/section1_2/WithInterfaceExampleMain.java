package oop.section1_2;

public class WithInterfaceExampleMain {
    public static void main(String[] args) {
        MessageSender messageSender = new FakeMessageSender();
        Client client = new Client(messageSender);
        client.doSomething();
    }
}
