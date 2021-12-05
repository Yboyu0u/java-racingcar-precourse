package racingcar;

import racingcar.domain.car.RandomMovingPolicy;
import racingcar.domain.game.GameMachine;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        GameMachine gameMachine = new GameMachine(new RandomMovingPolicy(), new InputView(), new OutputView());
        gameMachine.run();
    }
}
