package racingcar.Controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Model.Car;
import racingcar.Model.WinnerFinder;
import racingcar.View.InputView;
import racingcar.View.OutputView;

import java.util.ArrayList;
import java.util.List;

// 게임의 전체 흐름을 제어하는 책임 (Model과 View를 연결)
public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }


    public void run() {
        List<Car> cars = setupCarsWithoutRetry();
        int tryCount = setupTryCountWithoutRetry();

        outputView.printResultMessage();
        playRacingRounds(cars, tryCount);

        determineAndPrintWinners(cars);
    }

    private List<Car> setupCarsWithoutRetry() {
        String carNamesInput = inputView.readCarNames();
        return createCarsFromNames(carNamesInput);
    }

    private List<Car> createCarsFromNames(String carNamesInput) {
        String[] carNames = carNamesInput.split(",");
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name.trim()));
        }
        // 생성된 cars 리스트가 비어있거나, 유일한 요소가 빈 이름인지 확인
        if (cars.isEmpty() || (cars.size() == 1 && cars.get(0).getName().isEmpty())) {
            throw new IllegalArgumentException("자동차 이름을 1개 이상 입력해주세요.");
        }
        return cars;
    }

    private int setupTryCountWithoutRetry() {
        String tryCountInput = inputView.readTryCount();
        return parseAndValidateTryCount(tryCountInput);
    }

    private int parseAndValidateTryCount(String tryCountInput) {
        int tryCount;
        try {
            tryCount = Integer.parseInt(tryCountInput.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
        validateTryCountIsPositive(tryCount);
        return tryCount;
    }


    private void validateTryCountIsPositive(int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }

    private void playRacingRounds(List<Car> cars, int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            runSingleRound(cars);
            outputView.printRoundResult(cars);
        }
    }

    private void runSingleRound(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            car.move(randomNumber);
        }
    }

    private void determineAndPrintWinners(List<Car> cars) {
        WinnerFinder winnerFinder = new WinnerFinder(cars);
        winnerFinder.findMaxScore(); // 내부적으로 maxScore 찾고
        winnerFinder.findWinner();   // winner 찾음
        List<String> winners = winnerFinder.getWinners();
        outputView.printWinners(winners);
    }
}