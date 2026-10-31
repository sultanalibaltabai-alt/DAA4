package experiments;

import java.util.Random;

public class RandomTextGenerator {

    public static final String ALPHABET = "abcd";
    public static final long SEED = 42;

    private final Random random = new Random(SEED);

    public String generate(int length) {
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            text.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
        }
        return text.toString();
    }
}