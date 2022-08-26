package carraceing;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarRaceTest {

    @Test
    @DisplayName("0값이 들어오면 예외가 발생한다")
    void throws_exception_zero_insert() {
        int input = 0;
        Assertions.assertThatThrownBy(() -> CarRace.addCarCount(input))
                  .isInstanceOf(IllegalArgumentException.class)
                  .hasMessage("0값이 들어오면 예외가 발생한다");
    }
}
