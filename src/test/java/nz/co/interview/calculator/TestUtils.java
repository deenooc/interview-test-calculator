package nz.co.interview.calculator;

import java.util.Random;

public class TestUtils {

    private static final Random random = new Random();

    public static int getRandomInteger() {
        return random.nextInt(1000);
    }

    public static String getRandomCharacter() {
        return String.valueOf((char)(random.nextInt(95)+32));
    }
}
