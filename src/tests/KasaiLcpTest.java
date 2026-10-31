package tests;

import suffix.KasaiLcp;
import suffix.SuffixArrayBuilder;

public class KasaiLcpTest {

    public static void run() {
        String text = "banana";
        int[] expectedSuffixArray = {5, 3, 1, 0, 4, 2};
        int[] expectedLcp = {0, 1, 3, 0, 0, 2};

        KasaiLcp kasai = new KasaiLcp();
        SuffixArrayBuilder builder = new SuffixArrayBuilder();

        TestHelper.assertArrayEquals("Kasai LCP for banana", expectedLcp, kasai.build(text, expectedSuffixArray));
        TestHelper.assertArrayEquals("Suffix array for banana", expectedSuffixArray, builder.build(text));
    }
}