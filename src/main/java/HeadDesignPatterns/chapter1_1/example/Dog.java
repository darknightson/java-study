package HeadDesignPatterns.chapter1_1.example;

public class Dog extends Animal{
    @Override
    void makeSound() {
        bark();
    }

    public void bark() {
        System.out.println("짖음");
    }
}
