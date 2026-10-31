package dp;

public class EditDistance {

    public int distance(String first, String second) {
        int[][] table = new int[first.length() + 1][second.length() + 1];

        for (int i = 0; i <= first.length(); i++) {
            table[i][0] = i;
        }
        for (int j = 0; j <= second.length(); j++) {
            table[0][j] = j;
        }

        for (int i = 1; i <= first.length(); i++) {
            for (int j = 1; j <= second.length(); j++) {
                int substitutionCost = 0;
                if (first.charAt(i - 1) != second.charAt(j - 1)) {
                    substitutionCost = 1;
                }

                int deletion = table[i - 1][j] + 1;
                int insertion = table[i][j - 1] + 1;
                int substitution = table[i - 1][j - 1] + substitutionCost;

                table[i][j] = Math.min(deletion, Math.min(insertion, substitution));
            }
        }

        return table[first.length()][second.length()];
    }
}