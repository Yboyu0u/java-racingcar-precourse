package racingcar.validation.validator;

import java.util.List;

import racingcar.domain.Car;
import racingcar.validation.GlobalValidation;

public class CarsValidator {
	private static final int LIMIT_CAR_NAME_LENGTH = 5;
	private static final int MIN_CARS_LENGTH = 2;

	private static final String CAR_IS_UNDER_TWO_ERROR = "자동차는 두 대 이상이여야 합니다.";
	private static final String CAR_IS_DISTINCT_ERROR = "자동차 이름은 중복될 수 없습니다.";
	private static final String CAR_NAME_IS_OVER_FIVE_ERROR = "자동차 이름은 5자 이하여야 합니다.";
	private static final String CAR_NAME_IS_BLANK_ERROR = "자동차 이름은 빈 값일 수 없습니다.";
	private static final String CARS_ARE_BLANK_ERROR = "자동차 이름들은 빈 값일 수 없습니다.";

	public static void validateInputCars(String input) {
		GlobalValidation.validateInputIsBlank(input, CARS_ARE_BLANK_ERROR);
	}

	public static void validateInputCars(List<Car> cars) {
		validateCarsAreUnderTwo(cars);
		validateCarIsDistinct(cars);

		for(Car car : cars) {
			validateCarNameIsOver(car.getName());
			GlobalValidation.validateInputIsBlank(car.getName(),CAR_NAME_IS_BLANK_ERROR);
		}
	}

	private static void validateCarsAreUnderTwo(List<Car> cars) {
		if (cars.size() < MIN_CARS_LENGTH) {
			throw new IllegalArgumentException(CAR_IS_UNDER_TWO_ERROR);
		}
	}

	private static void validateCarIsDistinct(List<Car> cars) {
		if (cars.stream().distinct().count() != cars.size()) {
			throw new IllegalArgumentException(CAR_IS_DISTINCT_ERROR);
		}
	}

	private static void validateCarNameIsOver(String name) {
		if (name.length() > LIMIT_CAR_NAME_LENGTH) {
			throw new IllegalArgumentException(CAR_NAME_IS_OVER_FIVE_ERROR);
		}
	}
}
