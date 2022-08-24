package carraceing;

public class Car {

    private final int carNumber;

    public Car(int carNumber) {
        if (carNumber == 0 ) {
            throw new IllegalArgumentException();
        }
        this.carNumber = carNumber;
    }


}
