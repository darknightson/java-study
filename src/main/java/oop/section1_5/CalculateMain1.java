package oop.section1_5;

public class CalculateMain1 {
    public static void main(String[] args) {

        double add = Calculate1.ADD.apply(2, 5);
        double multiply = Calculate1.MULTIPLY.apply(2, 5);

        System.out.println("add = " + add);
        System.out.println("multiply = " + multiply);

    }
}
