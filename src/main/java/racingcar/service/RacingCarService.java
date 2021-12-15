package racingcar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RacingResultMachine;

public class RacingCarService {
	private static final String CAR_DIVISOR = ",";

	private RacingResultMachine racingResultMachine;

	public List<Car> postCarNames(String inputString) {
		//TODO: validation 추가
		return makeCarList(inputString);
	}

	public void postNumberOfRacing(String inputString, List<Car> cars) {
		//TODO: validation 추가
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

		Arrays.stream(cars.split(CAR_DIVISOR))
			.forEach(car -> carList.add(new Car(car)));

		return carList;
	}
}
