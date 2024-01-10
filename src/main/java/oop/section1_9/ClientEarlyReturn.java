package oop.section1_9;


public class ClientEarlyReturn {

    public int someMethod(CalculateCommand calculateCommand) {
        CalculateType calculateType = calculateCommand.getCalculateType();
        int num1 = calculateCommand.getNum1();
        int num2 = calculateCommand.getNum2();

        int result = 0;

        if ( calculateType == null ) {
            return result;
        }

        if ( calculateType.equals(CalculateType.DIVIDE) && num2 == 0 ) {
            throw new RuntimeException("num2 cannot be 0");
        }

        // 널체크와 예외처리를 빼고 나머지는 모두 같은 로직이다. 하지만 복잡하다.
        if ( calculateType.equals(CalculateType.ADD)) {
            result = num1 + num2;
        }
        else if ( calculateType.equals(CalculateType.MINUS)) {
            result = num1 - num2;
        }
        else if ( calculateType.equals(CalculateType.MULTIPLY)) {
            result = num1 * num2;
        }
        else if ( calculateType.equals(CalculateType.DIVIDE)) {
            result = num1 / num2;
        }

        return result;
    }
}
