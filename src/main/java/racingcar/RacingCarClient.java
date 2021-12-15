package racingcar;

import racingcar.controller.RacingCarController;

public class RacingCarClient {

	private RacingCarController racingCarController = new RacingCarController();

	public void play() {
		racingCarController.postCarNames();
		racingCarController.getRacingResult();
		racingCarController.getWinner();
	}
}
