package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
		Collections.sort(carList);
		decideWinnerList();
	}

	private void decideWinnerList() {
		ResponseMessage.printWinner(carList.stream()
			.filter(car -> car.getPosition() == carList.get(0).getPosition())
			.map(car -> car.getName())
			.collect(Collectors.toList()));
	}
}
