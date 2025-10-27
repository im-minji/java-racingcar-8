package racingcar;

import racingcar.Model.Car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("자동차 이름이 5자를 초과하면 예외 발생")
    void createCar_WithLongNameOver5_ShouldThrowException() {
        String longName = "pobiwoni"; // 6자
        assertThatThrownBy(() -> new Car(longName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5글자 이하여야 합니다.");
    }

    @Test
    @DisplayName("자동차 이름이 공백이면 예외 발생")
    void createCar_WithBlankName_ShouldThrowException() {
        String blankName = " ";
        assertThatThrownBy(() -> new Car(blankName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백일 수 없습니다.");
    }

    @Test
    @DisplayName("자동차 이름이 빈 문자열이면 예외 발생")
    void createCar_WithEmptyName_ShouldThrowException() {
        String emptyName = "";
        assertThatThrownBy(() -> new Car(emptyName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백일 수 없습니다.");
    }


    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("랜덤 숫자가 4 이상이면 전진한다")
    void move_WhenNumberIs4orMore_ShouldIncreasePosition(int randomNumber) {
        Car car = new Car("pobi");
        car.move(randomNumber);
        // getPosition() getter가 Car 클래스에 필요
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("랜덤 숫자가 4 미만이면 멈춘다")
    void move_WhenNumberIsLessThan4_ShouldNotIncreasePosition(int randomNumber) {
        Car car = new Car("pobi");
        car.move(randomNumber);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("maxScore 메서드는 더 큰 점수를 반환한다")
    void maxScore_ShouldReturnBiggerScore() {
        // 테스트를 위해 move를 사용
        Car car = new Car("pobi");
        car.move(4); // position 1
        car.move(4); // position 2
        car.move(4); // position 3

        int currentMaxScore = 5;
        int newMaxScore = car.getMaxPosition(currentMaxScore);
        assertThat(newMaxScore).isEqualTo(5);

        currentMaxScore = 2;
        newMaxScore = car.getMaxPosition(currentMaxScore);
        assertThat(newMaxScore).isEqualTo(3);
    }

    @Test
    @DisplayName("addNameToListIfWinner 메서드는 우승자일 경우 리스트에 이름을 추가한다")
    void addNameToListIfWinner_WhenIsWinner_ShouldAddName() {
        Car winnerCar = new Car("pobi");
        winnerCar.move(4);
        winnerCar.move(4);
        winnerCar.move(4);
        winnerCar.move(4);
        winnerCar.move(4);

        int maxScore = 5;
        List<String> winners = new ArrayList<>();
        winnerCar.addNameToListIfWinner(maxScore, winners);
        // getName() getter가 Car 클래스에 필요
        assertThat(winners).containsExactly(winnerCar.getName());
    }

    @Test
    @DisplayName("addNameToListIfWinner 메서드는 우승자가 아닐 경우 리스트에 이름을 추가하지 않는다")
    void addNameToListIfWinner_WhenNotWinner_ShouldNotAddName() {
        Car loserCar = new Car("woni");
        loserCar.move(4);
        loserCar.move(4);
        loserCar.move(4);

        int maxScore = 5;
        List<String> winners = new ArrayList<>();
        loserCar.addNameToListIfWinner(maxScore, winners);
        assertThat(winners).isEmpty();
    }
}