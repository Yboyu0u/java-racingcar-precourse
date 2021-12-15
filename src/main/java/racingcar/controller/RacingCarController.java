package racingcar.controller;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.exception.dto.ErrorResponse;
import racingcar.message.Message;
import racingcar.message.dto.ResponseMessage;
import racingcar.service.RacingCarService;

public class RacingCarController {

	private RacingCarService racingCarService;

	public RacingCarController() {
		this.racingCarService = new RacingCarService();
	}

	public void postCarNames() {
		try {
			ResponseMessage.of(Message.ENTER_CAR_NAMES.getMessage());
			postNumberOfRacingAndTakeCars(racingCarService.postCarNames(Console.readLine()));
		} catch (IllegalArgumentException e) {
			ErrorResponse.of(e.getMessage());
			postCarNames();
		}
	}

	private void postNumberOfRacingAndTakeCars(List<Car> cars) {
		try {
			ResponseMessage.of(Message.ENTER_NUMBER_OF_RACING.getMessage());
			racingCarService.postNumberOfRacing(Console.readLine(),cars);
		} catch (IllegalArgumentException e) {
			ErrorResponse.of(e.getMessage());
		}
	}

	public void getRacingResult() {
		ResponseMessage.printLineBreaker();
		ResponseMessage.of(Message.PRINT_RESULT.getMessage());
		racingCarService.getRacingResult();
	}

	public void getWinner() {
		racingCarService.getWinner();
	}

}
