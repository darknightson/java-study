package oop.section1_7;

public class EqualsExampleMain {

    public static void main(String[] args) {
        SomeObject someObject1 = new SomeObject(1, "someObject");
        SomeObject someObject2 = new SomeObject(1, "someObject");

        SomeObject anotherObject = new SomeObject(2, "anotherObject");

        // 동일성 비교 -> false
        System.out.println(someObject1 == someObject2);

        // 동등성 비교 -> true
        System.out.println(someObject1.equals(someObject2));

        // 동등성 비교 동일성 비교 false
        System.out.println(someObject1.equals(anotherObject));
        System.out.println(someObject1 == anotherObject);
    }
}
