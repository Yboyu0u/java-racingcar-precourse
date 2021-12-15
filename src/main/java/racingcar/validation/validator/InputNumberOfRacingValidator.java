package racingcar.validation.validator;

import racingcar.validation.GlobalValidation;

public class InputNumberOfRacingValidator {
	private static final int ZERO_LENGTH = 0;

	private static final String NUMBER_OR_RACING_IS_BLANK_ERROR = "시도 횟수는 빈 값일 수 없습니다.";
	private static final String NUMBER_OR_RACING_IS_NOT_NATURAL_NUMBER_ERROR = "시도 횟수는 자연수여야 합니다.";

	public static void validateNumberOfRacing(String input) {
		GlobalValidation.validateInputIsBlank(input,NUMBER_OR_RACING_IS_BLANK_ERROR);
		validateNumberOfRacingIsNaturalNumber(input);
	}


	private static void validateNumberOfRacingIsNaturalNumber(String input) {
		for (char c : input.toCharArray()) {
			if (!Character.isDigit(c)) {
				throw new IllegalArgumentException(NUMBER_OR_RACING_IS_NOT_NATURAL_NUMBER_ERROR);
			}
		}

		if (Integer.parseInt(input) == ZERO_LENGTH) {
			throw new IllegalArgumentException(NUMBER_OR_RACING_IS_NOT_NATURAL_NUMBER_ERROR);
		}
	}
}
