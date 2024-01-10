package cleanCode.errorHandling;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitExceptionHandlingTTest {

    @DisplayName("")
    @Test
    void retrieveSection() {
        // given & when & then
        UnitExceptionHandlingT unitExceptionHandlingT = new UnitExceptionHandlingT();
        Assertions.assertThatThrownBy(() -> {
            unitExceptionHandlingT.retrieveSection(null);
        }).isInstanceOf(DeviceShutDownError.class);


    }


}