package racingcar.validation;

public class GlobalValidation {
	private static final int ZERO_LENGTH = 0;
	private static final String SPACE = " ";
	private static final String NULL = "";

	public static void validateInputIsBlank(String input, String errorMessage) {
		if (input.replaceAll(SPACE, NULL).length() == ZERO_LENGTH) {
			throw new IllegalArgumentException(errorMessage);
		}
	}
}
