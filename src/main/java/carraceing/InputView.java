package carraceing;

import com.sun.net.httpserver.Authenticator.Success;
import java.util.Random;

public class InputView {

    private int suceess;
    private Random random = new Random();

    int getSuceess() {
        return suceess;
    }

    void tryForward() {
        if (4 < random.nextInt(10)) {
            suceess++;
        }
    }
}
