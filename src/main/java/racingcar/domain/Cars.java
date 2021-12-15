package racingcar.domain;

import java.util.List;

import racingcar.message.dto.ResponseMessage;
import racingcar.util.RandomUtil;

public class Cars {
	private static final String CAR_DIVISOR = ",";

	private List<Car> carList;
	private int numberOfRacing;

	public Cars(List<Car> cars, int numberOfRacing) {
		this.carList = cars;
		this.numberOfRacing = numberOfRacing;
	}

	public void playRacing() {
		for (int i = 0; i < numberOfRacing; i++) {
			playARacing();
			ResponseMessage.printResultOneRacing(carList);
			ResponseMessage.printLineBreaker();
		}
	}

	public void playARacing() {
		carList.stream()
			.forEach(car -> car.addPosition(RandomUtil.generateRandomNumber()));
	}

	public void getWinnerInCarList() {
		// position이 가장 많은 차들이 우승
	}
}
