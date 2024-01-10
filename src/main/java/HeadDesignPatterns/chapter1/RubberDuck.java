package HeadDesignPatterns.chapter1;

public class RubberDuck extends Duck {

    @Override
    public void display() {
        System.out.println("고무오리");
    }

    @Override
    public void quack() {
        System.out.println("삑삑");
    }

    @Override
    public void fly() {
        System.out.println("고무오리는 날지못해");
    }

    public static void main(String[] args) {
        RubberDuck duck = new RubberDuck();
        duck.display();
        duck.fly();
        duck.quack();
    }
}
