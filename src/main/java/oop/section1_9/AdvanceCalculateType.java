package oop.section1_9;

import java.util.function.BiFunction;

public enum AdvanceCalculateType {
    ADD (Integer::sum),
    MINUS ((num1, num2) -> num1 - num2),
    MULTIPLY ((num1, num2) -> num1 * num2),
    DIVIDE ((num1, num2) -> num1 / num2);

    AdvanceCalculateType(BiFunction<Integer, Integer, Integer> expression) {
        this.expression = expression;
    }

    private final BiFunction<Integer, Integer, Integer> expression;

    public int calculate(int num1, int num2) {
        return this.expression.apply(num1, num2);
    }
}
