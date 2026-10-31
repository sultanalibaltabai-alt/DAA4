package matching;

import java.util.ArrayList;
import java.util.List;

public class NaiveSearcher implements StringSearcher {

    private long comparisons;

    @Override
    public List<Integer> search(String text, String pattern) {
        comparisons = 0;
        List<Integer> result = new ArrayList<>();

        if (pattern.isEmpty() || pattern.length() > text.length()) {
            return result;
        }

        for (int start = 0; start <= text.length() - pattern.length(); start++) {
            int matched = 0;

            while (matched < pattern.length()) {
                comparisons++;
                if (text.charAt(start + matched) != pattern.charAt(matched)) {
                    break;
                }
                matched++;
            }

            if (matched == pattern.length()) {
                result.add(start);
            }
        }

        return result;
    }

    @Override
    public long getComparisons() {
        return comparisons;
    }

    @Override
    public String getName() {
        return "Naive";
    }
}