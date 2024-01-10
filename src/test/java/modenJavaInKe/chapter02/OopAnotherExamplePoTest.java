package modenJavaInKe.chapter02;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;



class OopAnotherExamplePoTest {

    @Test
    void additionTest() {
        Calculation calculation = new Addition();
        final int calculate = calculation.calculate(2, 1);
        System.out.println("calculate = " + calculate);
        Assertions.assertThat(calculate).isEqualTo(3);
    }

    @Test
    void subtractionTest() {
        Calculation calculation = new Subtraction();
        final int calculate = calculation.calculate(2, 1);
        System.out.println("calculate = " + calculate);
        Assertions.assertThat(calculate).isEqualTo(1);
    }
}