package carraceing;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarRaceTest {

    @Test
    @DisplayName("0값이 들어오면 예외가 발생한다.")
    void throws_exception_zero_insert_car_count(){
        Assertions.assertThatThrownBy(() -> new Car(0,0))
            .isInstanceOf(IllegalArgumentException.class);
    }


}
