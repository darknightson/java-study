package HeadDesignPatterns.chapter1_1.example;

public class Cat extends Animal {

    @Override
    void makeSound() {
        meow();
    }

    private void meow() {
        System.out.println("야옹 소리를 냄");
    }
}
