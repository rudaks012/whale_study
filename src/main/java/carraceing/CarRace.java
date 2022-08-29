package carraceing;

import java.util.Scanner;

public class CarRace {


    public static void main(String[] args) {
        ResultView resultView = new ResultView();
        Car car = new Car();

        Scanner scn = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carName = scn.nextLine();

        String[] carNames = carName.split(",");

        car.addCarList(carNames);

        int carCount = carNames.length;

        System.out.println("시도할 회수는 몇 대인가요?");
        int attempts = scn.nextInt();

        System.out.println("실행 결과");
        resultView.setGameStart(carCount, attempts);
    }
}
