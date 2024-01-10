package HeadDesignPatterns.chapter1_1;

public abstract class Duck {

    public FlyBehavior flyBehavior;
    public QuackBehavior quackBehavior;

    public Duck() {
    }

    public void setFlyBehavior(FlyBehavior fb) {
        this.flyBehavior = fb;
    }

    public void setQuackBehavior(QuackBehavior qb) {
        this.quackBehavior = qb;
    }

    public void performQuack() {
        // 행동 클래스에 위임한다.
        quackBehavior.quack();
    }

    public void swim() {
        System.out.println("모든 오리는 물이 뜹니다. 가짜 오리도 뜨죠 그러므로 공통 입니다.");
    }

    public abstract void display();

    public void performFly() {
        // 행동 클래스에 위임한다.
        flyBehavior.fly();
    }

}
