package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("1,2를 ',' 로 잘 분리가 되는지 확인한다.")
    public void splitTest() {
        String given = "1,2";

        String[] givenSplit = given.split(",");

        assertThat(givenSplit).hasSize(2);

    }

    @Test
    @DisplayName("1을 ',' 로 분리 했을때 1만을 포함하는 배열이 반환되는지 확인한다.")
    public void splitContainsTest() {
        String given = "1";

        String[] givenSplit = given.split(",");

        assertThat(givenSplit).contains("1");
    }

    @Test
    @DisplayName("(1,2)의 값이 주어졌을때 ()를 제거 하고 1,2를 반환 하는지 확인한다.")
    public void substringTest() {
        String given = "(1,2)";

        String givenSubstring = given.substring(1, given.length()-1);

        assertThat(givenSubstring).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt 메소드를 활용해 특정 위치의 문자를 가져오는지 확인한다.")
    public void chatAtVerfication() {
        String given = "abc";

        char givenChatAt = given.charAt(0);

        assertThat(givenChatAt).isEqualTo('a');
    }

    @Test
    @DisplayName("특정 문자의 위치를 가져오는데 범위를 벗어나면 예외가 발생한다")
    public void assertThatThrownByVerification() {
        String given = "abc";

        assertThatThrownBy(() -> given.charAt(5))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("range: 5");
    }

    @Test
    @DisplayName("특정 문자의 위치를 가져오는데 범위를 벗어나면 예외가 발생한다")
    public void assertThatExceptionOfTypeVerification() {
        String given = "abc";

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(()-> given.charAt(5))
                .withMessage ("String index out of range: 5");
    }
}
