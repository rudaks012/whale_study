package carraceing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Car {

    private int carCount;
    private int attempts;

    private final List<InputView> cars = new ArrayList<>();

    public Car(int carCount, int attempts){
        if (carCount == 0) {
            throw new IllegalArgumentException();
        }
        if (attempts == 0) {
            throw new IllegalArgumentException();
        }
        this.carCount = carCount;
        this.attempts = attempts;
    }

    public void readToGame() {
        Scanner scn = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        carCount = scn.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        attempts = scn.nextInt();
    }

    private void setCarCount(){
        for (int i = 0; i <carCount ; i++) {
            cars.add(new InputView());
        }
    }

}
