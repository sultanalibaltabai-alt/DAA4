package experiments;

import dp.EditDistance;
import dp.LongestCommonSubsequence;

import java.util.ArrayList;
import java.util.List;

public class DynamicProgrammingExperiment {

    private static final int[] SIZES = {100, 500, 1000};

    public List<String> run() {
        List<String> rows = new ArrayList<>();
        rows.add("size,lcs_ms,edit_distance_ms");

        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        EditDistance editDistance = new EditDistance();
        RandomTextGenerator generator = new RandomTextGenerator();

        for (int size : SIZES) {
            String first = generator.generate(size);
            String second = generator.generate(size);

            double lcsTime = Timer.averageMillis(() -> lcs.length(first, second));
            double editDistanceTime = Timer.averageMillis(() -> editDistance.distance(first, second));

            rows.add(size + "," + Timer.format(lcsTime) + "," + Timer.format(editDistanceTime));
        }

        return rows;
    }
}