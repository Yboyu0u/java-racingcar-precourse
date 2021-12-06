package racingcar.view;

public class OutputView {
	public static final String ERROR_MESSAGE = "[ERROR] %s";
	public static final String RESULT_MESSAGE = "실행 결과";
	public static final String WINNER_MESSAGE = "최종 우승자 : %s";
	public static final String CAR_STATUS_MESSAGE = "%s : %s";

	public static void printfMessage(String message, Object... args) {
		System.out.printf(message, args);
		printNewLine();
	}

	public static void printNewLine() {
		System.out.println();
	}

	public static void printError(String error) {

		printfMessage(ERROR_MESSAGE, error);
	}

	public static void printWinner(String winner) {

		printfMessage(WINNER_MESSAGE, winner);
	}

	public static void printCarNameAndPosition(String name, StringBuilder position) {
		printfMessage(CAR_STATUS_MESSAGE, name, position);
	}

	public static void printRacingResult() {
		printNewLine();
		printfMessage(RESULT_MESSAGE);
	}
}


