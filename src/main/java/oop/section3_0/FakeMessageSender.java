package oop.section3_0;

public class FakeMessageSender implements MessageSender {

    @Override
    public void send(String message) {
        System.out.println("Fake message: " + message);
    }
}
