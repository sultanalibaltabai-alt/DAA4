package suffix;

public class KasaiLcp {

    public int[] build(String text, int[] suffixArray) {
        int length = text.length();
        int[] rank = new int[length];
        for (int i = 0; i < length; i++) {
            rank[suffixArray[i]] = i;
        }

        int[] lcp = new int[length];
        int commonLength = 0;

        for (int i = 0; i < length; i++) {
            if (rank[i] == 0) {
                commonLength = 0;
                continue;
            }

            int previous = suffixArray[rank[i] - 1];
            while (i + commonLength < length
                    && previous + commonLength < length
                    && text.charAt(i + commonLength) == text.charAt(previous + commonLength)) {
                commonLength++;
            }

            lcp[rank[i]] = commonLength;

            if (commonLength > 0) {
                commonLength--;
            }
        }

        return lcp;
    }
}