package experiments;

import matching.KmpSearcher;
import matching.NaiveSearcher;
import matching.RabinKarpSearcher;
import matching.StringSearcher;

import java.util.ArrayList;
import java.util.List;

public class StringMatchingExperiment {

    private static final int[] TEXT_LENGTHS = {10000, 50000, 100000};
    private static final int PATTERN_LENGTH = 20;

    public List<String> run() {
        List<String> rows = new ArrayList<>();
        rows.add("text_length,pattern,algorithm,time_ms,comparisons,occurrences");

        StringSearcher[] searchers = {new NaiveSearcher(), new KmpSearcher(), new RabinKarpSearcher()};
        RandomTextGenerator generator = new RandomTextGenerator();

        for (int length : TEXT_LENGTHS) {
            String text = generator.generate(length);
            String presentPattern = text.substring(length / 2, length / 2 + PATTERN_LENGTH);
            String absentPattern = presentPattern.substring(0, PATTERN_LENGTH - 1) + "z";

            addRows(rows, searchers, text, presentPattern, "present");
            addRows(rows, searchers, text, absentPattern, "absent");
        }

        return rows;
    }

    private void addRows(List<String> rows, StringSearcher[] searchers,
                         String text, String pattern, String patternType) {
        for (StringSearcher searcher : searchers) {
            double time = Timer.averageMillis(() -> searcher.search(text, pattern));

            List<Integer> found = searcher.search(text, pattern);
            long comparisons = searcher.getComparisons();

            rows.add(text.length() + "," + patternType + "," + searcher.getName() + ","
                    + Timer.format(time) + "," + comparisons + "," + found.size());
        }
    }
}