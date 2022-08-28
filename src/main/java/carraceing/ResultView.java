package carraceing;

import java.util.List;
import java.util.Random;

public class ResultView {

    public void setGameStart(int carCount, int attempts) {
        Car car = new Car();
        Random randomValues = new Random();
        if (carCount == 0 && attempts == 0) {
            throw new IllegalArgumentException("0값이 들어오면 예외가 발생한다");
        }

        List<Car> cars = car.addCarCount(carCount);

        for (int i = 0; i < attempts; i++) {
            for (Car inputView : cars) {
                inputView.forward(randomValues.nextInt(10));
                resultPrint(inputView);
            }
            System.out.println();
        }
    }

    private void resultPrint(Car inputView) {
        for (int j = 0; j < inputView.getPosition(); j++) {
            System.out.print("-");
        }
        for (int i = 0; i < inputView.getPosition(); i++) {

        }
        System.out.println();
    }
}
