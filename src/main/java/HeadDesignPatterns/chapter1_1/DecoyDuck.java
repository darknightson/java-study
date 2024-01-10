package HeadDesignPatterns.chapter1_1;

import HeadDesignPatterns.chapter1.Duck;

public class DecoyDuck extends HeadDesignPatterns.chapter1.Duck {
    @Override
    public void quack() {
        System.out.println("소리 못냄");
    }

    @Override
    public void display() {
        System.out.println("가짜오리");
    }

    @Override
    public void fly() {
        System.out.println("날지못함");
    }


    public static void main(String[] args) {
        Duck duck = new DecoyDuck();
        duck.quack();
        duck.display();
        duck.fly();
    }
}
