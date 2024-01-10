package abstractandinterface.exam;

public abstract class Animal extends Creature {

    public Animal(int x, int y, int age) {
        super(x, y, age);
    }

    @Override
    public void attack() {
        System.out.println("animal attack");
    }
}
