package racingcar;

import java.util.List;

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

    public void move(int randomNumber) {
        if(randomNumber >= 4) {
            this.positions++;
        }
    }

    public void printResult() {
        System.out.print(this.name + " : ");
        for(int k =0; k<this.positions; k++) {
            System.out.print("-");
        }
        System.out.println(" ");
    }

    public int maxScore(int currentMaxScore) {
        currentMaxScore = Math.max(this.positions, currentMaxScore);
        return currentMaxScore;
    }

    public void addNameToListIfWinner(int maxScore, List<String> winnerList) {
        if(this.positions == maxScore) {
            winnerList.add(this.name);
        }
    }

}
