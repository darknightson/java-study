package oop.section1_5;

public class Client {

    public int someMethod(CalculateCommand calculateCommand) {
        CalculateType calculateType = calculateCommand.getCalculateType();
        return calculateType.calculate(calculateCommand.getNum1(), calculateCommand.getNum2());
    }
}
