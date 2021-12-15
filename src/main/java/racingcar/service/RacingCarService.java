package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Cars;

public class RacingCarService {

	private Cars cars;

	public void postCarNames(String inputString) {
		//TODO: validation 추가

		// 입력받은 자동차이름들 carList 에 저장
		cars.addCarInCarList(inputString);
	}

	public void postNumberOfRacing(String inputString) {
		//TODO: validation 추가

		// 입력 받은 횟수 객체에 저장
		cars.canSetNumberOfRacing(Integer.parseInt(inputString));
	}

	public void getRacingResult() {

	}
}
