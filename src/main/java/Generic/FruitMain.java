package Generic;

public class FruitMain {

    public static void main(String[] args) {
        AppleFruit appleFruit = new AppleFruit();
        appleFruit.setColor("red");
        appleFruit.setName("apple");

        FruitBoxGen<AppleFruit> appleFruitFruitBoxGen = new FruitBoxGen<>();
        appleFruitFruitBoxGen.setFruits(appleFruit);

        System.out.println("appleFruitFruitBoxGen.getFruits() = " + appleFruitFruitBoxGen.getFruits());
    }
}
