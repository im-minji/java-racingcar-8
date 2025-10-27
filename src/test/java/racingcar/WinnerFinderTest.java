package racingcar;

import racingcar.Model.Car;
import racingcar.Model.WinnerFinder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class WinnerFinderTest {

    private List<Car> carsWithCoWinners;
    private List<Car> carsWithSingleWinner;

    @BeforeEach
    void setUp() {
        // 공동 우승자 시나리오
        Car pobiCo = new Car("pobi");
        moveCar(pobiCo, 3); // position 3
        Car woniCo = new Car("woni");
        moveCar(woniCo, 5); // position 5
        Car junCo = new Car("jun");
        moveCar(junCo, 5); // position 5
        carsWithCoWinners = Arrays.asList(pobiCo, woniCo, junCo);

        // 단독 우승자 시나리오
        Car pobiSingle = new Car("pobi");
        moveCar(pobiSingle, 7); // position 7
        Car woniSingle = new Car("woni");
        moveCar(woniSingle, 5); // position 5
        Car junSingle = new Car("jun");
        moveCar(junSingle, 5); // position 5
        carsWithSingleWinner = Arrays.asList(pobiSingle, woniSingle, junSingle);
    }

    // 테스트를 위한 Car 이동 헬퍼 메서드
    private void moveCar(Car car, int times) {
        for (int i = 0; i < times; i++) {
            car.move(4); // 무조건 전진하는 숫자(4 이상) 사용
        }
    }

    @Test
    @DisplayName("findWinner 메서드는 공동 우승자들을 정확히 찾는다")
    void findWinner_ShouldFindCoWinners() {
        WinnerFinder finder = new WinnerFinder(carsWithCoWinners);

        finder.findMaxScore(); // 내부적으로 maxScore 계산
        finder.findWinner();   // 내부적으로 winners 리스트 채움

        List<String> actualWinners = finder.getWinners();
        assertThat(actualWinners)
                .hasSize(2)
                .containsExactlyInAnyOrder("woni", "jun"); // 순서 상관없이 이름 일치 확인
    }

    @Test
    @DisplayName("findWinner 메서드는 단독 우승자를 정확히 찾는다")
    void findWinner_ShouldFindSingleWinner() {
        WinnerFinder finder = new WinnerFinder(carsWithSingleWinner);
        finder.findMaxScore();
        finder.findWinner();
        List<String> actualWinners = finder.getWinners();
        assertThat(actualWinners)
                .hasSize(1)
                .containsExactly("pobi");
    }
}