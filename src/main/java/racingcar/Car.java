package racingcar;

public class Car {
    private final String name;
    private int positions;

    Car(String name, int positions) {
        this.name = name;
        this.positions = positions;

        if(name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이하여야 합니다.");
        }

        if(name.trim().isEmpty()) {
            throw new IllegalArgumentException("이름을 정확하게 입력해주세요.");
        }
    }
}
