package abstractandinterface.exam;

public abstract class Human extends Creature implements Talkable {

    public Human(int x, int y, int age) {
        super(x, y, age);
    }

    @Override
    public void attack() {
        System.out.println("휴먼 도구를 사용");
    }

    @Override
    public void talk() {
        System.out.println("휴먼은 말을 한다.");
    }
}
