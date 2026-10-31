package tests;

import java.util.Arrays;

public class TestHelper {

    private static int passed = 0;
    private static int failed = 0;

    public static void assertEquals(String testName, Object expected, Object actual) {
        if (expected.equals(actual)) {
            passed++;
            System.out.println("PASS: " + testName);
        } else {
            failed++;
            System.out.println("FAIL: " + testName + " | expected: " + expected + " | actual: " + actual);
        }
    }

    public static void assertArrayEquals(String testName, int[] expected, int[] actual) {
        if (Arrays.equals(expected, actual)) {
            passed++;
            System.out.println("PASS: " + testName);
        } else {
            failed++;
            System.out.println("FAIL: " + testName + " | expected: " + Arrays.toString(expected)
                    + " | actual: " + Arrays.toString(actual));
        }
    }

    public static void printSummary() {
        System.out.println();
        System.out.println("Passed: " + passed);
        System.out.println("Failed: " + failed);
    }
}