package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

// 전체 애플리케이션 실행 관점에서 입력을 테스트
class ApplicationInputTest extends NsTest {

    @Test
    @DisplayName("시도 횟수에 숫자가 아닌 값을 입력하면 예외 발생")
    void application_WhenTryCountIsNotNumber_ShouldThrowIllegalArgumentException() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "a"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("시도 횟수는 숫자여야 합니다.")
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-10"})
    @DisplayName("시도 횟수에 0 이하의 숫자를 입력하면 예외 발생")
    void application_WhenTryCountIsZeroOrLess_ShouldThrowIllegalArgumentException(String invalidTryCount) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", invalidTryCount))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("시도 횟수는 1 이상이어야 합니다.")
        );
    }

    @Test
    @DisplayName("정상적인 입력 시 예외가 발생하지 않음")
    void application_WhenInputIsValid_ShouldNotThrowException() {
        assertSimpleTest(() -> {
            run("pobi,woni", "5"); // 정상적인 이름과 횟수 입력
        });
    }

    @Override
    public void runMain() {Application.main(new String[]{});}
}
