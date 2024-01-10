package oop.section1_2;

public class RealMessageSender implements MessageSender {
    @Override
    public void send() {
        System.out.println("real send message");
    }
}
