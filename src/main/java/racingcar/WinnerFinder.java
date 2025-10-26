package racingcar;

import java.util.ArrayList;
import java.util.List;

public class WinnerFinder {
    private List<Car> racingCars;
    private int maxScore;
    private List<String> winners;

    WinnerFinder(List<Car> racingCars) {
        this.racingCars = racingCars;
        this.maxScore = 0;
        this.winners = new ArrayList<>();
    }


    void findMaxScore() {
        for (Car currentCar : racingCars) {
            this.maxScore = currentCar.maxScore(maxScore);
        }
    }


    void findWinner() {
        for (Car currentCar : racingCars) {
            currentCar.addNameToListIfWinner(this.maxScore, this.winners);
        }
    }

    public List<String> getWinners() {
        return this.winners;
    }

}
