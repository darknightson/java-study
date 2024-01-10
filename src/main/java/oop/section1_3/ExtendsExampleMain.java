package oop.section1_3;

public class ExtendsExampleMain {
    public static void main(String[] args) {
        Parent parent = new Parent();
        Parent extendedParent = new Child(); // 다형성
        Child child = new Child();

        parent.someMethod();
        extendedParent.someMethod();
        // extendedParent.anotherMethod(); // Child 인스턴스 이지만 Parent 타입으로 선언되었기 때문에 사용 불가
    }
}
