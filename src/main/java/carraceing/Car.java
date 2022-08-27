package carraceing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Car {

    private int position;


    public int getPosition() {
        return position;
    }

    public void movingCar() {
        forward(fourMoreMoving());
    }

    public void forward(boolean forward) {
        if (!forward) {
            return;
        }
        position++;
    }

    public boolean fourMoreMoving() {
        return new Random().nextInt(10) >= 4;
    }

    public List<Car> addCarCount(int carCount) {
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
        return cars;
    }

}
