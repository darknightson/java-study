package TDD;

import java.util.Scanner;

public class SampleApplication {
    public static void main(String[] args) {
        CalculationRequest calculationRequest = new CalculationRequestReader().read();
        long answer = Calculator.calculate(calculationRequest.getNum1(),
                calculationRequest.getNum2(),
                calculationRequest.getOperator());
    }
}
