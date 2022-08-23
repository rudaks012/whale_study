package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();

        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("size 메소드를 확용해 크기를 확인.")
    void setSizeTest() {
        int size = numbers.size();

        assertThat(size).isEqualTo(3);
    }

    @Test
    @DisplayName("contains 메소드를 활용해 1,2,3의 값이 존재 하는지 확인.")
    void containsTest() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @DisplayName("parameterizedTest 를 활용해 중복코드를 제거.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void parameterized(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @DisplayName("메소드 실행결과 true,4,5 값을 넣으면 false 가 반환되는지 확인.")
    @ParameterizedTest(name = "값:{0}, 결과:{1}")
    @CsvSource(value = {
            "1: true",
            "2: true",
            "3: true",
            "4: false",
            "5: false"
    }, delimiter = ':')
    void csvSource(int number, boolean expected) {
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }
}
