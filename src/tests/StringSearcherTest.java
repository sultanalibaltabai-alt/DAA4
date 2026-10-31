package tests;

import matching.KmpSearcher;
import matching.NaiveSearcher;
import matching.RabinKarpSearcher;
import matching.StringSearcher;

import java.util.List;

public class StringSearcherTest {

    private static final StringSearcher[] SEARCHERS = {
            new NaiveSearcher(), new KmpSearcher(), new RabinKarpSearcher()
    };

    public static void run() {
        check("Pattern at the beginning", "abcdef", "abc", List.of(0));
        check("Pattern in the middle", "abcdef", "cd", List.of(2));
        check("Pattern at the end", "abcdef", "def", List.of(3));
        check("Multiple occurrences", "abababa", "aba", List.of(0, 2, 4));
        check("Pattern absent", "abcdef", "xyz", List.of());
        check("Pattern longer than text", "abc", "abcdef", List.of());
        check("Empty pattern", "abc", "", List.of());
    }

    private static void check(String testName, String text, String pattern, List<Integer> expected) {
        for (StringSearcher searcher : SEARCHERS) {
            List<Integer> actual = searcher.search(text, pattern);
            TestHelper.assertEquals(testName + " [" + searcher.getName() + "]", expected, actual);
        }
    }
}