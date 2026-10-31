package suffix;

import java.util.Arrays;

public class SuffixArrayBuilder {

    public int[] build(String text) {
        Integer[] indices = new Integer[text.length()];
        for (int i = 0; i < indices.length; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, (first, second) -> compareSuffixes(text, first, second));

        int[] suffixArray = new int[text.length()];
        for (int i = 0; i < suffixArray.length; i++) {
            suffixArray[i] = indices[i];
        }
        return suffixArray;
    }

    private int compareSuffixes(String text, int first, int second) {
        while (first < text.length() && second < text.length()) {
            if (text.charAt(first) != text.charAt(second)) {
                return text.charAt(first) - text.charAt(second);
            }
            first++;
            second++;
        }

        int firstLeft = text.length() - first;
        int secondLeft = text.length() - second;
        return firstLeft - secondLeft;
    }
}