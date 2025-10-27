package racingcar.View;

import racingcar.Model.Car; // Car 클래스 import
import java.util.List;

public class OutputView {

    public void printResultMessage() {
        System.out.println("\n실행 결과");
    }

    public void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            printDashes(car.getPosition());
            System.out.println();
        }
        System.out.println(); // 라운드 끝난 후 빈 줄
    }

    // '-' 출력 메서드
    private void printDashes(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print("-");
        }
    }

    public void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
