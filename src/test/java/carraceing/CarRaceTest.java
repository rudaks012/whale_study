package carraceing;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarRaceTest {
    private final Car car = new Car();

    @Test
    @DisplayName("0값이 들어오면 예외가 발생한다")
    void throws_exception_zero_insert() {
        int input = 0;

        assertThatThrownBy(() -> car.addCarCount(input))
                  .isInstanceOf(IllegalArgumentException.class)
                  .hasMessage("0값이 들어오면 예외가 발생한다");
    }
}
