package racingcar.exception.dto;

public class ErrorResponse {
	private static final String ERROR = "[ERROR] ";

	public static void of(String errorMessage) {
		System.out.println(ERROR + errorMessage);
	}
}
