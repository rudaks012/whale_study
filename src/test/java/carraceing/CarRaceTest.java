package carraceing;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarRaceTest {

    @Test
    @DisplayName("전진이 된다면 Position의 값이 1 증가한다.")
    void forward_add_plus_one() {
        Car car = new Car();
        int actual = car.getPosition();
        int expected = 1;

        car.forward(true);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("0값이 들어오면 예외가 발생한다")
    void throws_exception_zero_insert1() {
        int carCount = 0;
        int attempts = 0;
        ResultView resultView = new ResultView();

        assertThatThrownBy(() -> resultView.setGameStart(carCount,attempts))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("0값이 들어오면 예외가 발생한다");
    }
}
