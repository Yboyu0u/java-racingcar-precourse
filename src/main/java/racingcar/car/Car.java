package racingcar.car;

public class Car {
    private static final int DEFAULT_POSITION = 0;
    private static final int NAME_MAX_LENGTH = 5;
    private static final String NAME_MESSAGE_FORMAT = "%s : ";
    private static final int ZERO_INDEX = 0;
    private static final String MOVING_STICK = "-";

    private final String name;
    private final MovingPolicy movingPolicy;
    private int position = DEFAULT_POSITION;

    public Car(String name, MovingPolicy movingPolicy) {
        validateName(name);
        this.name = name;
        this.movingPolicy = movingPolicy;
    }

    private void validateName(String name) {
        validateLength(name);
    }

    private void validateLength(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
    
    protected void move() {
        if (movingPolicy.isMoving()) {
            position++;
        }
    }

    protected String getStateMessage() {
        StringBuilder stringBuilder = new StringBuilder(String.format(NAME_MESSAGE_FORMAT, name));
        for (int i = ZERO_INDEX; i < position; i++) {
            stringBuilder.append(MOVING_STICK);
        }
        return stringBuilder.toString();
    }

    protected String getName() {
        return name;
    }

    protected int getPosition() {
        return position;
    }

    protected boolean isSamePosition(int maxPosition) {
        if (this.position == maxPosition) {
            return true;
        }
        return false;
    }
}