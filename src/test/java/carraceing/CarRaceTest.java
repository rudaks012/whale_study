package carraceing;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarRaceTest {

    @Test
    @DisplayName("0값이 들어오면 예외가 발생확인")
    void throws_exception_zero_insert1() {
        int carCount = 0;
        int attempts = 0;
        ResultView resultView = new ResultView();

        assertThatThrownBy(() -> resultView.setGameStart(carCount, attempts))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("0값이 들어오면 예외가 발생한다");
    }

    @ParameterizedTest(name = "자동차 대수만큼 리스트는 증가하는지 확인 : [{index}] : [{arguments}]")
    @ValueSource(ints = {
        1, 2, 3
    })
    void input_carcount_list_space_check(int expected) {
        Car car = new Car();

        int actual = car.addCarCount(expected).size();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("전진이 된다면 Position의 값이 1 증가한다.")
    void forward_add_plus_one() {
        Car car = new Car();

        car.forward(true);

        int actual = car.getPosition();
        int expected = 1;

        assertThat(actual).isEqualTo(expected);
    }

}
