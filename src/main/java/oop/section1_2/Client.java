package oop.section1_2;

public class Client {

    private final MessageSender messageSender;

    public Client(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void doSomething() {
        messageSender.send();
    }
}
