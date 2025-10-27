package racingcar.Model;

import java.util.List;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MOVE_THRESHOLD = 4;

    private final String name;
    private int position; // positions -> position

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = 0;
    }

    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 " + MAX_NAME_LENGTH + "글자 이하여야 합니다.");
        }
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVE_THRESHOLD) {
            this.position++;
        }
    }

    public int getMaxPosition(int currentMaxPosition) {
        return Math.max(this.position, currentMaxPosition);
    }

    public void addNameToListIfWinner(int maxPosition, List<String> winnerList) {
        if (this.position == maxPosition) {
            winnerList.add(this.name);
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}