package effectivejava.chapter2;

public enum OrderStatus {

    PREPARING(1),
    SHIPPED(2),
    DELIVERING(3),
    DELIVERED(4);

    private int number;

    OrderStatus(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
