package oop.section1_2;

public class FakeMessageSender implements MessageSender {
    @Override
    public void send() {
        System.out.println("fake send message");
    }
}
