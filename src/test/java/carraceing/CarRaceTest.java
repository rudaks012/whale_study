package carraceing;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarRaceTest {

    @Test
    @DisplayName("몇대의 자동차로 이동하는지 확인 한다.")
    void See_how_many_cars_are_traveling() {
        int carNumbers = 3;

        Car actual = new Car(carNumbers);

        assertThat(actual).isNotNull();
    }

    @Test
    @DisplayName("자동차 대수에 0 값이 들어오면 예외가 발생한다.")
    void throws_exception_zero_car_number() {
        assertThatThrownBy(() -> new Car(0))
            .isInstanceOf(IllegalArgumentException.class);

    }

    @ParameterizedTest(name = "값이 4 이상이면 전진한다")
    @ValueSource(ints = {
        4, 5, 6, 7, 8, 9
    })
    void random_value_is_four_or_higher_move_forward(int input) {
        assertThat(input).isGreaterThan(3);
    }

    @ParameterizedTest(name = "값이 4이하면 이동하지 않는다.")
    @ValueSource(ints = {
        1, 2, 3
    })
    void random_value_is_three_or_down_not_move_forward(int input) {
        assertThat(input).isLessThan(4);
    }
}
