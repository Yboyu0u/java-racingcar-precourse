package racingcar.service;

import java.util.List;

import racingcar.Car;
import racingcar.view.OutputView;

public class OutputService {
	private static final String DISTANCE = "-";

	public static void getOneRoundRacingResult(List<Car> cars){
		for (Car car: cars){
			StringBuilder distance = getCarMovedDistance(car.getPosition());
			OutputView.printCarNameAndPosition(car.getName(), distance);
		}
		OutputView.printNewLine();
	}

	public static StringBuilder getCarMovedDistance(int position){
		StringBuilder movedDistance = new StringBuilder();
		for (int i = 0; i < position; i++){
			movedDistance.append(DISTANCE);
		}
		return movedDistance;
	}
}