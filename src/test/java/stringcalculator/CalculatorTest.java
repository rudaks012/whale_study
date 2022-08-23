package stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import yongju.Cal;

class CalculatorTest {

    @Test
    @DisplayName("계산기 객체 생성")
    void Create_calculator_object() {
        String formula = "2 + 3";
        Cal actual = new Cal(formula);

        assertThat(actual).isEqualTo(new Cal(formula));
    }

    @ParameterizedTest(name = "null 또는 빈 값이 들어오면 예외가 발생한다: [{index}]: [{arguments}]")
    @NullAndEmptySource
    void create_exception_null_or_empty(String input) {
        assertThatThrownBy(() -> new Calculator(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("빈 값이 들어오면 예외가 발생한다.");
    }

    @ParameterizedTest(name = "수식이 숫자로 시작하지 않으면 예외가 발생한다 : [{index}]: [{arguments}]")
    @ValueSource(strings = {
        "+",
        "가",
        "a"
    })
    void throws_exception_does_not_start_with_number(String input) {
        assertThatThrownBy(() -> new Calculator(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("숫자로 시작하지 않아 예외가 발생했다");
    }

    @ParameterizedTest(name = "수식이 숫자로 끝나지 않으면 예외가 발생한다 : [{index}]: [{arguments}]")
    @ValueSource(strings = {
        "1 가 ",
        "1 +",
        "1 a"
    })
    void throws_exception_does_not_end_with_number(String input) {
        assertThatThrownBy(() -> new Calculator(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("숫자로 끝나지 않아 예외가 발생했다");
    }

    @ParameterizedTest(name = "숫자와 연산자는 공백으로 구분한다")
    @ValueSource(strings = {
        "1 + + 2",
        "1 ++ 2",
        "1 +2",
        "1+ 2",
        "1+2",
    })
    void number_and_operators_space_separated(String input) {
        assertThatThrownBy(() -> new Calculator(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("공백으로 구분이 되지 않았습니다.");
    }

    @ParameterizedTest(name = "지원하지 않는 연산자를 사용하면 예외가 발생한다.")
    @ValueSource(strings = {
        "1 $ 1",
        "2 # 7",
        "4 ^ 8",
        "3 | 3"
    })
    void throws_exception_unsupported_use_operator(String operator) {
        assertThatThrownBy(() -> new Calculator(operator))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("지원하지 않는 연산자 입니다");
    }

    @Test
    @DisplayName("피연산자 0으로 나누면 예외가 발생한다")
    void throws_exception_dividing_by_zero() {
        Calculator calculator = new Calculator("1 / 0");

        assertThatThrownBy(() -> calculator.calculator())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("0으로 나눌 수 없습니다.");
    }


    @ParameterizedTest(name = "사칙연산을 정확하게 하는지 확인한다: [{index}] : [{arguments}]")
    @CsvSource(value = {
        "1 + 2, 3",
        "1 + 2 + 3, 6",
        "1 + 2 + 3 + 6, 12"
    })
    void calculate(String formula, int expected) {
        Calculator calculator = new Calculator(formula);

        int actual = calculator.calculator();

        assertThat(actual).isEqualTo(expected);
    }
}
