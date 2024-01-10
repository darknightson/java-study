package oop.section1_9;


import javax.management.RuntimeMBeanException;

public class Client {

    public int someMethod(CalculateCommand calculateCommand) {
        CalculateType calculateType = calculateCommand.getCalculateType();
        int num1 = calculateCommand.getNum1();
        int num2 = calculateCommand.getNum2();

        int result = 0;
        // if 문이 많아서 복잡하다.
        if ( calculateType != null && calculateType.equals(CalculateType.ADD)) {
            result = num1 + num2;
        }
        else if ( calculateType != null && calculateType.equals(CalculateType.MINUS)) {
            result = num1 - num2;
        }
        else if ( calculateType != null && calculateType.equals(CalculateType.MULTIPLY)) {
            result = num1 * num2;
        }
        else if ( calculateType != null && calculateType.equals(CalculateType.DIVIDE)) {
            if (num2 == 0 ) {
                throw new RuntimeException("num2 cannot be 0");
            }
            else {
                result = num1 / num2;
            }
        }

        return result;
    }
}
