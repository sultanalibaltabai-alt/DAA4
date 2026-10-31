package matching;

import java.util.ArrayList;
import java.util.List;

public class KmpSearcher implements StringSearcher {

    private long comparisons;

    @Override
    public List<Integer> search(String text, String pattern) {
        comparisons = 0;
        List<Integer> result = new ArrayList<>();

        if (pattern.isEmpty() || pattern.length() > text.length()) {
            return result;
        }

        int[] lps = buildLpsTable(pattern);
        int textIndex = 0;
        int patternIndex = 0;

        while (textIndex < text.length()) {
            comparisons++;
            if (text.charAt(textIndex) == pattern.charAt(patternIndex)) {
                textIndex++;
                patternIndex++;

                if (patternIndex == pattern.length()) {
                    result.add(textIndex - patternIndex);
                    patternIndex = lps[patternIndex - 1];
                }
            } else if (patternIndex > 0) {
                patternIndex = lps[patternIndex - 1];
            } else {
                textIndex++;
            }
        }

        return result;
    }

    private int[] buildLpsTable(String pattern) {
        int[] lps = new int[pattern.length()];
        int length = 0;
        int index = 1;

        while (index < pattern.length()) {
            comparisons++;
            if (pattern.charAt(index) == pattern.charAt(length)) {
                length++;
                lps[index] = length;
                index++;
            } else if (length > 0) {
                length = lps[length - 1];
            } else {
                lps[index] = 0;
                index++;
            }
        }

        return lps;
    }

    @Override
    public long getComparisons() {
        return comparisons;
    }

    @Override
    public String getName() {
        return "KMP";
    }
}