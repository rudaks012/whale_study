package carraceing;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarRaceTest {

    @Test
    @DisplayName("입력 받은 값을 split으로 나누고 결과 값이 예상한 결과과 일치하는지 확인")
    void car_name_split() {
        String[] actual = "pobi,crong,honux".split(",");

        assertThat(actual).containsExactly("pobi", "crong", "honux");

    }

    @Test
    @DisplayName("0값이 들어오면 예외가 발생확인")
    void throws_exception_zero_insert1() {
        int carCount = 0;
        int attempts = 0;
        ResultView resultView = new ResultView();

        assertThatThrownBy(() -> resultView.setGameStart (carCount, attempts))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("0값이 들어오면 예외가 발생한다");
    }

    @ParameterizedTest(name = "자동차 대수만큼 리스트는 증가하는지 확인 : [{index}] : [{arguments}]")
    @ValueSource(ints = {
        1, 2, 3
    })
    void input_car_count_list_space_check(int expected) {
        Car car = new Car();

        int actual = car.addCarCount(expected).size();

        assertThat(actual).isEqualTo(expected);
    }

//    @Test
//    @DisplayName("전진이 된다면 Position의 값이 1 증가한다.")
//    void forward_add_plus_one() {
//        Car car = new Car();
//
//        car.forward(3);
//
//        int actual = car.getPosition();
//        int expected = 1;
//
//        assertThat(actual).isEqualTo(expected);
//    }
//
//    @Test
//    @DisplayName("전진이 되지 않는다면 Position의 값은 0이다.")
//    void no_forward_position_value_zero() {
//        Car car = new Car();
//
////        car.forward(false);
//
//        int actual = car.getPosition();
//        int expected = 0;
//
//        assertThat(actual).isEqualTo(expected);
//    }

    @ParameterizedTest(name = "랜덤값이 4이상이면 전진한다 : [{index}] : [{arguments}]")
    @ValueSource(ints = {
        4, 5, 6
    })
    void four_more_car_forward(int input) {
        Car car = new Car();

        car.forward(input);
        int actual = car.getPosition();
        int expected = 1;

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest(name = "랜덤값이 4이하이면 전진하지않는다 : [{index}] : [{arguments}]")
    @ValueSource(ints = {
        1, 2, 3
    })
    void four_less_not_car_forward(int input) {
        Car car = new Car();

        car.forward(input);
        int actual = car.getPosition();
        int expected = 0;

        assertThat(actual).isEqualTo(expected);
    }

}
