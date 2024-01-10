package oop.section1_4;

public class AbstractMain {

    public static void main(String[] args) {
        // AbstractClass abstractClass = new AbstractClass(); // 추상 클래스는 인스턴스화 할 수 없음
        // 추상 클래스는 인스턴스할 수 없지만 , 추상 메서드를 구현함으로써 가능하게할 수 있음.
        AbstractClass abstractClass = new AbstractClass() {
            @Override
            public void abstractMethod() {
                System.out.println("abstractClass abstractMethod");
            }
        };

        abstractClass.abstractMethod();
        abstractClass.implementedMethod();

        AbstractClass extendedAbstractClass = new ExtendedAbstractClass();
        extendedAbstractClass.implementedMethod();
        extendedAbstractClass.abstractMethod();
    }
}
