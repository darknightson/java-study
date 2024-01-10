package modenJavaInKe.chapter01;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SubCalculationTest {

    @Test
    void additionTest() {
        Calculation calculation = new AdditionCalculation();
        final int calculate = calculation.calculate(1, 2);
        assertThat(calculate).isEqualTo(3);
    }

}