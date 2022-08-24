package carraceing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Car {

    private final Random random = new Random();
    private final List<Integer> cars = new ArrayList<>();
    private final int carCount;

    public Car(int carCount) {
        if (carCount == 0) {
            throw new IllegalArgumentException("0이 입력되면 예외가 발생한다.");
        }
        if (Character.isDigit(carCount)) {
            throw new IllegalArgumentException("문자열이 입력되면 예외가 발생한다.");
        }
        this.carCount = carCount;
    }

    public void carDriving() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요");

        int carCount = scanner.nextInt();
        if (carCount == 0) {
            throw new IllegalArgumentException("0이 입력되면 예외가 발생한다.");
        }
    }
}
