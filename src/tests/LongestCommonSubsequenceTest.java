package tests;

import dp.LongestCommonSubsequence;

public class LongestCommonSubsequenceTest {

    public static void run() {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();

        TestHelper.assertEquals("LCS identical strings", 5, lcs.length("abcde", "abcde"));
        TestHelper.assertEquals("LCS completely different strings", 0, lcs.length("abc", "xyz"));
        TestHelper.assertEquals("LCS second string empty", 0, lcs.length("abc", ""));
        TestHelper.assertEquals("LCS first string empty", 0, lcs.length("", "abc"));
        TestHelper.assertEquals("LCS classic example", 4, lcs.length("ABCBDAB", "BDCABA"));
    }
}