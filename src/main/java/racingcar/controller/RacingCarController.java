package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
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
			racingCarService.postCarNames(Console.readLine());
		} catch (IllegalArgumentException e) {
			ErrorResponse.of(e.getMessage());
			postCarNames();
		}
	}

	public void postNumberOfRacing() {

		try {
			ResponseMessage.of(Message.ENTER_NUMBER_OF_RACING.getMessage());
			racingCarService.postNumberOfRacing(Console.readLine());
		} catch (IllegalArgumentException e) {
			ErrorResponse.of(e.getMessage());
			postNumberOfRacing();
		}
	}

	public void getRacingResult() {
		ResponseMessage.of(Message.PRINT_RESULT.getMessage());
		racingCarService.getRacingResult();
	}

}
