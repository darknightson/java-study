package TDD;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculationRequestTest {

    @DisplayName("유효한 숫자를 파싱할 수 있다.")
    @Test
    void validNumberParsing() {

        // given
        String[] parts = new String[]{"2", "3", "+"};

        // when
        CalculationRequest calculationRequest = new CalculationRequest(parts);

        // then
        assertEquals(2, calculationRequest.getNum1());
        assertEquals(3, calculationRequest.getNum2());
        assertEquals("+", calculationRequest.getOperator());
    }

    @DisplayName("입력 값이 누락 되었으면 에러를 던진다.")
    @Test
    void inputThrow() {

        // given
        String[] parts = new String[]{"2", "3"};

        // when & then
        assertThrows(BadRequestException.class, () -> new CalculationRequest(parts));
        assertThatThrownBy(() -> new CalculationRequest(parts))
                .isInstanceOf(BadRequestException.class)
                .hasMessage("Invalid input");
    }

    @DisplayName("유효하지 않은 연산자기 입력되면 에러를 던진다.")
    @Test
    void operatorThrow() {

        // given
        String[] parts = new String[]{"2", "3", "x"};

        // when & then
        assertThatThrownBy(() -> new CalculationRequest(parts))
                .isInstanceOf(InvalidOperatorException.class);
    }

    @DisplayName("연산자의 길이가 1이 아니면 에러를 던진다.")
    @Test
    void operatorLengthThrow() {

        // given
        String[] parts = new String[]{"2", "3", "+11"};

        // when & then
        assertThatThrownBy(() -> new CalculationRequest(parts))
                .isInstanceOf(InvalidOperatorException.class);
    }

}