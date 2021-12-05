package racingcar.domain.car;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @DisplayName("이름 리스트와 MovingPolicy이 주어지면 정상적으로 생성된다.")
    @Test
    void constructor_movingConditionThenNotNull_success() {
        // given
        MovingPolicy movingPolicy = new RandomMovingPolicy();
        List<String> names = new ArrayList<>(Arrays.asList("pobi", "woni", "jun"));

        // when & then
        assertThatCode(() -> {
            new Cars(names, movingPolicy);
        }).doesNotThrowAnyException();
    }

    @DisplayName("isMoving이 true이면 position이 일괄적으로 증가한다.")
    @Test
    void move_isMovingThenTrue_carsIncreasePosition() {
        // given
        MovingPolicy movingPolicy = () -> true;
        List<String> names = new ArrayList<>(Arrays.asList("pobi", "woni", "jun"));
        Cars cars = new Cars(names, movingPolicy);

        // when
        cars.move();

        // then
        System.out.println(cars.getExecutionResult());
        assertThat(cars.getExecutionResult()).isEqualTo("pobi : -\nwoni : -\njun : -");
    }

    @DisplayName("isMoving이 false이면 position은 일괄적으로 정지한다.")
    @Test
    void move_isMovingThenFalse_carsStopPosition() {
        // given
        MovingPolicy movingPolicy = () -> false;
        List<String> names = new ArrayList<>(Arrays.asList("pobi", "woni", "jun"));
        Cars cars = new Cars(names, movingPolicy);

        // when
        cars.move();

        // then
        assertThat(cars.getExecutionResult()).isEqualTo("pobi : \nwoni : \njun : ");
    }

    @DisplayName("최종 우승자 안내 문구를 생성한다.")
    @Test
    void getWinnersNames_cars_create() {
        // given
        MovingPolicy movingPolicy = () -> true;
        List<String> names = new ArrayList<>(Arrays.asList("pobi", "woni", "jun"));
        Cars cars = new Cars(names, movingPolicy);

        // when
        cars.move();

        // then
        assertThat(cars.getWinnersNames()).isEqualTo("pobi, woni, jun");
    }
}