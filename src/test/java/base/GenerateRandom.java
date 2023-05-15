package base;

import java.util.Random;

public class GenerateRandom {
    public String generateRandomNumLettersLongString(int num) {
        String word = "";
        for (int i = 0; i < num; i++) {
            Random random = new Random();
            word += (char) random.nextInt(97,123);
        }
        return word;
    }

}
