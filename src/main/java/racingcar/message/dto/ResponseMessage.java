package racingcar.message.dto;

import java.util.List;

import racingcar.domain.Car;
import racingcar.message.Message;

public class ResponseMessage {
	private static final String POSITION_SIGN_UNIT = "-";
	private static final String NAME_POSITION_DIVISOR = " : ";
	private static final String WINNER_DIVISOR = ", ";

	public static void of(String message) {
		System.out.println(message);
	}

	public static void printResultOneRacing(List<Car> carList) {
		carList.stream().forEach(car -> printResultEachCar(car.getName(),car.getPosition()));
	}

	private static void printResultEachCar(String carName, int position) {
		System.out.println(carName + NAME_POSITION_DIVISOR + makePositionSignByPosition(position));
	}

	private static String makePositionSignByPosition(int position) {
		StringBuilder positionSign = new StringBuilder();

		for(int i=0; i<position; i++) {
			positionSign.append(POSITION_SIGN_UNIT);
		}

		return positionSign.toString();
	}

	public static void printWinner(List<String> winners) {
		System.out.print(Message.PRINT_WINNER.getMessage());

		for(int i=0; i<winners.size(); i++) {
			System.out.print(winners.get(i));
			checkFinalWinner(i, winners.size());
		}
	}

	private static void checkFinalWinner(int idx, int winnerSize) {
		if(idx != winnerSize-1) {
			System.out.print(WINNER_DIVISOR);
		}
	}

	public static void printLineBreaker() {
		System.out.println();
	}
}
