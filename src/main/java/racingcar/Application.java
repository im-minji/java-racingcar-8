package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        String carNames = inputConsole();
        List<Car> racingCars = createCarList(carNames);

        int tryCount = tryCountConsole();
    }

    static String inputConsole() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    static List<Car> createCarList(String carNames) {
        String[] carList = carNames.split(",");

        ArrayList<Car> racingCars = new ArrayList<>();

        for (String s : carList) {
            Car car = new Car(s, 0);
            racingCars.add(car);
        }
        return racingCars;
    }

    static int tryCountConsole() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int tryCount;

        try {
            tryCount = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("횟수(0 이상의 숫자)를 입력해주세요.");
        }

        tryCountIfNegative(tryCount);
        return tryCount;
    }

    static void tryCountIfNegative(int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException("횟수는 양수여야 합니다.");
        }
    }
}
