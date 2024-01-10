package oop.section1_9;

public class AdvanceCalculateCommand {
    private AdvanceCalculateType calculateType;
    private int num1;
    private int num2;

    public AdvanceCalculateCommand(AdvanceCalculateType calculateType, int num1, int num2) {
        if ( calculateType == null ) {
            throw new IllegalArgumentException("calculateType is null");
        }
        if ( calculateType.equals(AdvanceCalculateType.DIVIDE) && num2 == 0 ) {
            throw new IllegalArgumentException("num2 cannot be 0");
        }
        this.calculateType = calculateType;
        this.num1 = num1;
        this.num2 = num2;
    }

    public AdvanceCalculateType getCalculateType() {
        return calculateType;
    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }
}
