package carraceing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Car {

    private static final int RACE_CONDITION = 4;
    private int position;

    public int getPosition() {
        return position;
    }

    public void forward(int randomValues) {
        if (randomValues >= RACE_CONDITION) {
            position++;
        }
    }

    public List<Car> addCarCount(int carCount) {
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
        return cars;
    }

}
