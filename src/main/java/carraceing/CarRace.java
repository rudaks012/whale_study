package carraceing;

import java.util.Scanner;

public class CarRace {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        String carNumbers = scn.nextLine();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int attempts = scn.nextInt();
        scn.close();

        System.out.println("attempts = " + attempts);
        System.out.println("carNumbers = " + carNumbers);
    }

}
