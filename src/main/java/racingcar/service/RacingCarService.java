package racingcar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RacingResultMachine;
import racingcar.validation.GlobalValidation;
import racingcar.validation.validator.CarsValidator;
import racingcar.validation.validator.InputNumberOfRacingValidator;

public class RacingCarService {
	private static final String CAR_DIVISOR = ",";

	private RacingResultMachine racingResultMachine;

	public List<Car> postCarNames(String inputString) {
		GlobalValidation.validateInputIsBlank(inputString);
		return makeCarList(inputString);
	}

	public void postNumberOfRacing(String inputString, List<Car> cars) {
		InputNumberOfRacingValidator.validateNumberOfRacing(inputString);
		racingResultMachine = new RacingResultMachine(new Cars(cars, Integer.parseInt(inputString)));
	}

	public void getRacingResult() {
		racingResultMachine.getResult();
	}

	public void getWinner() {
		racingResultMachine.getWinner();
	}

	private List<Car> makeCarList(String cars) {
		List<Car> carList = new ArrayList<>();

		//TODO: 공백 밀어서 넣기
		Arrays.stream(cars.split(CAR_DIVISOR))
			.forEach(car -> carList.add(new Car(car)));

		CarsValidator.validateInputCars(carList);

		return carList;
	}
}
