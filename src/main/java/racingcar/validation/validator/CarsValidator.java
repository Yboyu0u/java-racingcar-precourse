package racingcar.validation.validator;

import java.util.List;

import racingcar.domain.Car;
import racingcar.validation.GlobalValidation;

public class CarsValidator {

	public static void validateInputCars(List<Car> cars) {
		GlobalValidation.validateCarsAreUnderTwo(cars);
		GlobalValidation.validateCarIsDistinct(cars);
		cars.stream().forEach(car -> GlobalValidation.validateCarNameIsOver(car.getName()));
	}

}
