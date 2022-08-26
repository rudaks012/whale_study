package carraceing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CarRace {

    private static final Random random = new Random();
    public Object isForward;

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = scn.nextInt();

        System.out.println("시도할 회수는 몇 대인가요?");
        int attempts = scn.nextInt();

        List<Car> cars = addCarCount(carCount);

        for (int i = 0; i < attempts; i++) {
            for (Car car : cars) {
                car.forward(random.nextInt(10) >= 4);
                System.out.println(car.getPosition());
            }
            System.out.println();
        }
    }

    public static List<Car> addCarCount(int carCount) {
        List<Car> cars = new ArrayList<>();
        if (carCount == 0) {
            throw new IllegalArgumentException("0값이 들어오면 예외가 발생한다");
        }

        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
        return cars;
    }
}
