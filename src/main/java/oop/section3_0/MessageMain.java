package oop.section3_0;

public class MessageMain {
    private final MessageSender messageSender;

    public MessageMain(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void send() {
        messageSender.send("Hello World!");
    }
}
