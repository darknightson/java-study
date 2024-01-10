package modenJavaInKe.chapter02;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculateServiceMethodTest {

    @Test
    void additionTest() {
        CalculateServiceMethod calculateServiceMethod = new CalculateServiceMethod();

        // 메서드에 객체를 넘겨준다.
        final int addCalculate = calculateServiceMethod.calculate(new Addition(), 2, 1);
        final int subtractionCalculate = calculateServiceMethod.calculate(new Subtraction(), 2, 1);
        final int multiplicationCalculate = calculateServiceMethod.calculate(new Multiplication(), 2, 1);

        Assertions.assertThat(addCalculate).isEqualTo(3);
        Assertions.assertThat(subtractionCalculate).isEqualTo(1);
        Assertions.assertThat(multiplicationCalculate).isEqualTo(2);


        // 람다로 변환
        final int addCalculateFunc = calculateServiceMethod.calculate((int i1, int i2) -> i1+i2, 2, 1);
        final int subtractionCalculateFunc = calculateServiceMethod.calculate((int i1, int i2) -> i1-i2, 2, 1);

        System.out.println("addCalculateFunc = " + addCalculateFunc);
        System.out.println("subtractionCalculateFunc = " + subtractionCalculateFunc);
    }

}