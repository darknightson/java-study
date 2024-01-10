package TDD;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

class CalculationRequestReaderTest {

    @DisplayName("System.in 으로 부터 계산식을 입력받는다.")
    @Test
    void read() {

        // given
        CalculationRequestReader calculationRequestReader = new CalculationRequestReader();
        System.setIn(new ByteArrayInputStream("2 3 +".getBytes()));

        // when
        CalculationRequest calculationRequest = calculationRequestReader.read();

        // then
        assertThat(2).isEqualTo(calculationRequest.getNum1());
        assertThat(3).isEqualTo(calculationRequest.getNum2());
        assertThat("+").isEqualTo(calculationRequest.getOperator());
    }
}