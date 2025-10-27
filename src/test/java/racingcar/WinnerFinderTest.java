package racingcar;

// Car와 WinnerFinder 클래스의 새로운 위치(패키지)를 알려줍니다.
import racingcar.Model.Car;
import racingcar.Model.WinnerFinder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class WinnerFinderTest {

    private List<Car> carsWithCoWinners; // 공동 우승자 테스트용
    private List<Car> carsWithSingleWinner; // 단독 우승자 테스트용

    @BeforeEach
    void setUp() {
        // 공동 우승자 시나리오: pobi(3), woni(5), jun(5)
        Car pobiCo = new Car("pobi");
        moveCar(pobiCo, 3); // position 3
        Car woniCo = new Car("woni");
        moveCar(woniCo, 5); // position 5
        Car junCo = new Car("jun");
        moveCar(junCo, 5); // position 5
        carsWithCoWinners = Arrays.asList(pobiCo, woniCo, junCo);

        // 단독 우승자 시나리오: pobi(7), woni(5), jun(5)
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

    // findMaxScore 테스트는 findWinner 테스트로 간접 검증합니다.
    // (findWinner가 올바른 우승자를 찾으면, findMaxScore도 올바르게 동작했다고 간주)

    @Test
    @DisplayName("findWinner 메서드는 공동 우승자들을 정확히 찾는다")
    void findWinner_ShouldFindCoWinners() {
        // given: setUp()에서 carsWithCoWinners 준비됨
        WinnerFinder finder = new WinnerFinder(carsWithCoWinners);

        // when: 우승자 판별 로직 실행
        finder.findMaxScore(); // 내부적으로 maxScore 계산
        finder.findWinner();   // 내부적으로 winners 리스트 채움

        // then: 결과 검증
        List<String> actualWinners = finder.getWinners(); // getWinners()를 통해 결과 확인
        assertThat(actualWinners)
                .hasSize(2) // 우승자는 2명이어야 함
                .containsExactlyInAnyOrder("woni", "jun"); // 순서 상관없이 이름 일치 확인
    }

    @Test
    @DisplayName("findWinner 메서드는 단독 우승자를 정확히 찾는다")
    void findWinner_ShouldFindSingleWinner() {
        // given: setUp()에서 carsWithSingleWinner 준비됨
        WinnerFinder finder = new WinnerFinder(carsWithSingleWinner);

        // when: 우승자 판별 로직 실행
        finder.findMaxScore();
        finder.findWinner();

        // then: 결과 검증
        List<String> actualWinners = finder.getWinners();
        assertThat(actualWinners)
                .hasSize(1) // 우승자는 1명이어야 함
                .containsExactly("pobi"); // 정확히 pobi만 포함 확인
    }
}