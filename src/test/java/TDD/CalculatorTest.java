package TDD;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @DisplayName("덧셈 테스트")
    @Test
    void calculatePlusTest() {

        // given
        long num1 = 2;
        long num2 = 3;
        String operator = "+";

        // when
        long result = Calculator.calculate(num1, num2, operator);

        // then
        assertEquals(5, result);
        Assertions.assertThat(result).isEqualTo(5);
    }

    @DisplayName("곱셈 테스트")
    @Test
    void calculateMultiplyTest() {

        // given
        long num1 = 2;
        long num2 = 3;
        String operator = "*";

        // when
        long result = Calculator.calculate(num1, num2, operator);

        // then
        assertEquals(6, result);
        Assertions.assertThat(result).isEqualTo(6);
    }

    @DisplayName("뺄셈 테스트")
    @Test
    void calculateMinusTest() {

        // given
        long num1 = 2;
        long num2 = 3;
        String operator = "-";

        // when
        long result = Calculator.calculate(num1, num2, operator);

        // then
        assertEquals(-1, result);
        Assertions.assertThat(result).isEqualTo(-1);
    }

    @DisplayName("뺄셈 테스트")
    @Test
    void calculateDivideTest() {

        // given
        long num1 = 6;
        long num2 = 3;
        String operator = "/";

        // when
        long result = Calculator.calculate(num1, num2, operator);

        // then
        assertEquals(2, result);
        Assertions.assertThat(result).isEqualTo(2);
    }

    @DisplayName("잘못된 연산자가 들어올 경우 예외가 발생해야 한다.")
    @Test
    void throwTest() {
        // given
        long num1 = 6;
        long num2 = 3;
        String operator = "x";

        // assertJ
        assertThatThrownBy(
                () -> Calculator.calculate(num1, num2, operator)
        ).isInstanceOf(InvalidOperatorException.class).hasMessage("Invalid Operator");

        // assertions
        assertThrows(InvalidOperatorException.class, () -> Calculator.calculate(num1, num2, operator));
    }
}