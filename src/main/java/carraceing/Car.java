package carraceing;

public class Car {

    private int position;

    public void forward(boolean forward) {
        if (forward) {
            position++;
        }
    }

    public String getPosition() {
        String result = "";
        for (int i = 1; i < position; i++) {
            System.out.print("-");
        }
        System.out.print("-");
        return result;
    }
}
