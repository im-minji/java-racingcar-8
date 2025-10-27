package racingcar;

import racingcar.Controller.RacingController;
import racingcar.View.InputView;
import racingcar.View.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        RacingController racingController = new RacingController(inputView, outputView);

        racingController.run();
    }
}