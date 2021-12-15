package racingcar.validation.validator;

import racingcar.validation.GlobalValidation;

public class InputNumberOfRacingValidator {

	public static void validateNumberOfRacing(String input) {
		GlobalValidation.validateInputIsBlank(input);
		GlobalValidation.validateNumberOfRacingIsNaturalNumber(input);
	}
}
