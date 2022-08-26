package carraceing;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private int position;

    public void forward(boolean forward) {
        if (!forward) {
            return;
        }
        position++;
    }

    public String getPosition() {
        String result = "";
        for (int i = 1; i < position; i++) {
            System.out.print("-");
        }
        System.out.print("-");
        return result;
    }

    public List<Car> addCarCount(int carCount) {
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
