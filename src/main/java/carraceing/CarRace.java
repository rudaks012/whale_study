package carraceing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CarRace {

    private static Random random = new Random();

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = scn.nextInt();

        System.out.println("시도할 회수는 몇 대인가요?");
        int attempts = scn.nextInt();

        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }

        for (int i = 0; i < attempts; i++) {
            for (Car car : cars) {
                car.forward(random.nextInt(10) > 4);
                System.out.println(car.getPosition());
            }
        }
    }
}
