package racingcar.domain;

import java.util.Arrays;
import java.util.List;

public class Cars {
	private static final String CAR_DIVISOR = ",";

	private List<Car> carList;
	private int numberOfRacing;

	public void addCarInCarList(String cars) {
		Arrays.stream(cars.split(CAR_DIVISOR))
			.forEach(car -> carList.add(new Car(car)));
	}

	public void canSetNumberOfRacing(int number) {
		if(number > 0) {
			numberOfRacing = number;
		}
	}
}
