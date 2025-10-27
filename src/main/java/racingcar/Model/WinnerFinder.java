package racingcar.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WinnerFinder {
    private final List<Car> cars;
    private int maxScore;
    private List<String> winners;

    public WinnerFinder(List<Car> racingCars) {
        this.cars = new ArrayList<>(racingCars);
        this.maxScore = 0;
        this.winners = new ArrayList<>();
    }

    public void findMaxScore() {
        for (Car currentCar : cars) {
            // Car: 더 큰 점수 계산
            this.maxScore = currentCar.getMaxPosition(maxScore);
        }
    }

    public void findWinner() {
        for (Car currentCar : cars) {
            currentCar.addNameToListIfWinner(this.maxScore, this.winners);
        }
    }

    public List<String> getWinners() {
        // 수정 불가능한 리스트를 반환
        return Collections.unmodifiableList(this.winners);
    }
}