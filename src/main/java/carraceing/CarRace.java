package carraceing;

import java.util.Scanner;

public class CarRace {


    public static void main(String[] args) {
        ResultView resultView = new ResultView();

        Scanner scn = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = scn.nextInt();

        System.out.println("시도할 회수는 몇 대인가요?");
        int attempts = scn.nextInt();

        resultView.setGameStart(carCount, attempts);
    }
}
