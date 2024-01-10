package abstractandinterface.exam;

public abstract class Creature {
    private int x; // 위치 좌표
    private int y; // 위치 좌표
    private int age; // 나이

    public Creature() {
    }

    public Creature(int x, int y, int age) {
        this.x = x;
        this.y = y;
        this.age = age;
    }

    public abstract void attack();
    public abstract void printInfo();

    public void age() {
        // 나이 증가
        age++;
    }

    public void move(int xDistance) {
        // x 거리
        x += xDistance;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Creature{" +
                "x=" + x +
                ", y=" + y +
                ", age=" + age +
                '}';
    }
}
