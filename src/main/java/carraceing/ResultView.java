package carraceing;

import java.util.List;

public class ResultView {

    public void setGameStart(int carCount, int attempts) {
        Car car = new Car();
        List<Car> cars = car.addCarCount(carCount);

        for (int i = 0; i < attempts; i++) {
            for (Car inputView : cars) {
                inputView.movingCar();
                for (int j = 0; j < inputView.getPosition(); j++) {
                    System.out.print("-");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

}
