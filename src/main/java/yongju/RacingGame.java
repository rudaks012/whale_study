package yongju;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RacingGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("대수?");
        int count = Integer.parseInt(scanner.nextLine());
        System.out.println("횟수?");
        int times = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            cars.add(new Car());
        }

        for (int i = 0; i < times; i++) {
            for (Car car : cars) {
                car.forward(new Random().nextInt(10) >= 4);
                System.out.println(car.getPosition());
            }
            System.out.println("");
        }
    }
}
