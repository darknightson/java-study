package oop.section1_5;

public class CalculateCommand2 {
    private final CalculateType2 calculateType;
    private final int num1;
    private final int num2;

    public CalculateCommand2(CalculateType2 calculateType, int num1, int num2) {
        this.calculateType = calculateType;
        this.num1 = num1;
        this.num2 = num2;
    }

    public CalculateType2 getCalculateType() {
        return calculateType;
    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }
}
