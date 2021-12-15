package racingcar.domain;

public class RacingResultMachine {

	private Cars cars;

	public RacingResultMachine(Cars cars) {
		this.cars = cars;
	}

	public void getResult() {
		cars.playRacing();
	}

	public void getWinner() {
		cars.getWinnerInCarList();
	}
}
