package racingcar.domain.game;

import java.util.List;

import racingcar.domain.car.Cars;
import racingcar.domain.car.MovingPolicy;
import racingcar.domain.trycount.TryCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameMachine {
    private final MovingPolicy movingPolicy;
    private final InputView inputView;
    private final OutputView outputView;

    public GameMachine(MovingPolicy movingPolicy, InputView inputView, OutputView outputView) {
        this.movingPolicy = movingPolicy;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Cars cars = getCars();
        TryCount tryCount = getTryCount();
        System.out.println();

        repeat(cars, tryCount);
    }

    private Cars getCars() {
        List<String> names = inputView.getNames();
        try {
            return new Cars(names, movingPolicy);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return getCars();
        }
    }

    private TryCount getTryCount() {
        try {
            return inputView.getTryCount();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return getTryCount();
        }
    }

    private void repeat(Cars cars, TryCount tryCount) {
        while (tryCount.hasNextCount()) {
            cars.move();
            outputView.printExecutionResult(cars.getExecutionResult());
        }
        outputView.printWinnerNames(cars.getWinnersNames());
    }
}