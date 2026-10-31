package tests;

public class AllTests {

    public static void main(String[] args) {
        LongestCommonSubsequenceTest.run();
        EditDistanceTest.run();
        StringSearcherTest.run();
        KasaiLcpTest.run();

        TestHelper.printSummary();
    }
}