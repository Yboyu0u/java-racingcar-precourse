package racingcar.message;

public enum Message {

	ENTER_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
	ENTER_NUMBER_OF_RACING("시도할 회수는 몇회인가요?"),
	PRINT_RESULT("실행 결과"),
	PRINT_WINNER("최종 우승자 : ");

	private String message;

	Message(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
