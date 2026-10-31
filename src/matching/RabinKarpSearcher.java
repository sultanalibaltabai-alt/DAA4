package matching;

import java.util.ArrayList;
import java.util.List;

public class RabinKarpSearcher implements StringSearcher {

    private static final int BASE = 31;
    private static final long MOD = 1_000_000_007L;

    private long comparisons;

    @Override
    public List<Integer> search(String text, String pattern) {
        comparisons = 0;
        List<Integer> result = new ArrayList<>();

        if (pattern.isEmpty() || pattern.length() > text.length()) {
            return result;
        }

        int patternLength = pattern.length();
        long highestPower = 1;
        for (int i = 0; i < patternLength - 1; i++) {
            highestPower = highestPower * BASE % MOD;
        }

        long patternHash = calculateHash(pattern, patternLength);
        long windowHash = calculateHash(text, patternLength);

        for (int start = 0; start <= text.length() - patternLength; start++) {
            if (patternHash == windowHash && matchesAt(text, pattern, start)) {
                result.add(start);
            }

            if (start < text.length() - patternLength) {
                long withoutFirst = (windowHash - text.charAt(start) * highestPower % MOD + MOD) % MOD;
                windowHash = (withoutFirst * BASE + text.charAt(start + patternLength)) % MOD;
            }
        }

        return result;
    }

    private long calculateHash(String value, int length) {
        long hash = 0;
        for (int i = 0; i < length; i++) {
            hash = (hash * BASE + value.charAt(i)) % MOD;
        }
        return hash;
    }

    private boolean matchesAt(String text, String pattern, int start) {
        for (int i = 0; i < pattern.length(); i++) {
            comparisons++;
            if (text.charAt(start + i) != pattern.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public long getComparisons() {
        return comparisons;
    }

    @Override
    public String getName() {
        return "Rabin-Karp";
    }
}