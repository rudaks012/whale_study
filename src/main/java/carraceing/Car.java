package carraceing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Car {

    private final List<InputView> cars = new ArrayList<>();

    private Random random = new Random();
    private int carCount;
    private int attempts;

    private int position;

    public Car(int carCount, int attempts) {
        if (carCount == 0) {
            throw new IllegalArgumentException();
        }
        if (attempts == 0) {
            throw new IllegalArgumentException();
        }
        this.carCount = carCount;
        this.attempts = attempts;
    }

    public int getPosition() {
        return position;
    }

    public void process() {
        if (4 < random.nextInt(10)) {
            position++;
        }
    }

    public void readToGame() {
        Scanner scn = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        carCount = scn.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        attempts = scn.nextInt();

        for (int i = 0; i < carCount; i++) {
            cars.add(new InputView());
        }
    }

    private void setAttempts() {
        for (int i = 0; i < attempts; i++) {
            for(InputView car : cars){
                car.tryForward();
            }
        }
    }
}
