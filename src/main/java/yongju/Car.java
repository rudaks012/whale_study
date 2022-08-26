package yongju;

public class Car {

    private int position;

    public void forward(boolean b) {
        if (b) {
            position++;
        }
    }

    public String getPosition() {
        for (int i = 1; i < position; i++) {
            System.out.print("-");
        }
        System.out.print("-");
        return "";
    }
}