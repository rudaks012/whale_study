package carraceing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Car {

    private static final int RACE_CONDITION = 4;
    private static final int CAR_NAME_CONDITION = 5;
    private int position;
    private final List<String> carList = new ArrayList<>();

    public void addCarList(String[] carNames) {
        for (String carName : carNames) {
            validateCarNameLength(carName);
        }
        carList.addAll(Arrays.asList(carNames));
    }

    public List<String> getCarName() {
        return carList;
    }

    public void validateCarNameLength(String carName) {
        if (carName.length() > CAR_NAME_CONDITION) {
            throw new IllegalArgumentException("자동차 이름이 5글자를 초과하면 예외가 발생한다.");
        }
    }

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
