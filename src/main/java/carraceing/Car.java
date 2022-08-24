package carraceing;

import java.util.Random;

public class Car {
    private Random random = new Random();
    private final int car;

    public Car(int car) {
        if (car == 0 ) {
            throw new IllegalArgumentException();
        }
        if (Character.isDigit(car)){
            throw new IllegalArgumentException("문자열이 입력되면 예외가 발생한다.");
        }
        this.car = car;
    }

}
