package oop.section1_5;

public class Client2 {
    public int someMethod(CalculateCommand2 calculateCommand) {
        if ( calculateCommand.getCalculateType() == CalculateType2.ADD ) {
            return calculateCommand.getNum1() + calculateCommand.getNum2();
        } else if ( calculateCommand.getCalculateType() == CalculateType2.MULTIPLY ) {
            return calculateCommand.getNum1() * calculateCommand.getNum2();
        } else if ( calculateCommand.getCalculateType() == CalculateType2.DIVIDE ) {
            return calculateCommand.getNum1() / calculateCommand.getNum2();
        } else {
            throw new RuntimeException("Unknown calculate type: " + calculateCommand.getCalculateType());
        }
    }
}
