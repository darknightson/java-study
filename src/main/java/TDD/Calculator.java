package TDD;

public class Calculator {

    private Calculator() {
        throw new IllegalStateException("Utility class");
    }

    public static long calculate(long num1, long num2, String operator) {
        long answer = 0;
        switch (operator) {
            case "+":
                answer = num1 + num2;
                break;
            case "-":
                answer = num1 - num2;
                break;
            case "*":
                answer = num1 * num2;
                break;
            case "/":
                answer = num1 / num2;
                break;
            default:
                throw new InvalidOperatorException();
        }
        return answer;
    }
}
