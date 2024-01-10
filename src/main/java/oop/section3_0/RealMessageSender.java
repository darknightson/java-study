package oop.section3_0;

public class RealMessageSender implements MessageSender {

    @Override
    public void send(String message) {
        System.out.println("Real message: " + message);
    }
}
