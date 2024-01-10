package oop.section1_5;

import java.util.function.BiFunction;

public enum CalculateType {
    ADD((num1, num2) -> num1 + num2),
    DIVIDE((num1, num2) -> num1 / num2),
    MINUS((num1, num2) -> num1 - num2),
    MULTIPLY((num1, num2) -> num1 * num2);

    private final BiFunction<Integer, Integer, Integer> expression;

    CalculateType(BiFunction<Integer, Integer, Integer> calculate) {
        this.expression = calculate;
    }

    public int calculate(int num1, int num2) {
        return expression.apply(num1, num2);
    }
}
