package racingcar.validation;

import java.util.List;

import racingcar.domain.Car;

public class GlobalValidation {
	private static final int LIMIT_CAR_NAME_LENGTH = 5;
	private static final int MIN_CARS_LENGTH = 2;
	private static final int ZERO_LENGTH = 0;

	private static final String INPUT_IS_BLANK_ERROR = "입력 값은 빈 값일 수 없습니다.";
	private static final String CAR_IS_UNDER_TWO_ERROR = "자동차는 두 대 이상이여야 합니다.";
	private static final String CAR_IS_DISTINCT_ERROR = "자동차 이름은 중복될 수 없습니다.";
	private static final String CAR_NAME_IS_OVER_FIVE_ERROR = "자동차 이름은 5자 이하여야 합니다.";
	private static final String NUMBER_OR_RACING_IS_NOT_NATURAL_NUMBER_ERROR = "시도 횟수는 자연수여야 합니다.";


	// 입력이 빈 값으로 들어오는 경우   공통
	public static void validateInputIsBlank(String input) {
		if(input.replaceAll(" ","").length() == ZERO_LENGTH) {
			throw new IllegalArgumentException(INPUT_IS_BLANK_ERROR);
		}
	}

	// 자동차가 한 대 이하로 들어오는 경우
	public static void validateCarsAreUnderTwo(List<Car> cars) {
		if(cars.size() < MIN_CARS_LENGTH) {
			throw new IllegalArgumentException(CAR_IS_UNDER_TWO_ERROR);
		}
	}

	// 자동차가 중복돼서 들어오는 경우
	public static void validateCarIsDistinct(List<Car> cars) {
		if(cars.stream().distinct().count() != cars.size()) {
			throw new IllegalArgumentException(CAR_IS_DISTINCT_ERROR);
		}
	}

	// 자동차 이름이 5자가 초과되는 경우
	public static void validateCarNameIsOver(String name) {
		if(name.length() > LIMIT_CAR_NAME_LENGTH) {
			throw new IllegalArgumentException(CAR_NAME_IS_OVER_FIVE_ERROR);
		}
	}

	// 시도할 횟수가 자연수가 아닌 경우
	public static void validateNumberOfRacingIsNaturalNumber(String input) {
		for(char c: input.toCharArray()) {
			if(! Character.isDigit(c)) {
				throw new IllegalArgumentException(NUMBER_OR_RACING_IS_NOT_NATURAL_NUMBER_ERROR);
			}
		}

		if(Integer.parseInt(input) == ZERO_LENGTH) {
			throw new IllegalArgumentException(NUMBER_OR_RACING_IS_NOT_NATURAL_NUMBER_ERROR);
		}
	}
}
