package experiments;

import java.util.Locale;

public class Timer {

    private static final int WARM_UP_RUNS = 20;
    private static final int RUNS = 5;

    public static double averageMillis(Runnable task) {
        for (int run = 0; run < WARM_UP_RUNS; run++) {
            task.run();
        }

        long totalNanos = 0;

        for (int run = 0; run < RUNS; run++) {
            long start = System.nanoTime();
            task.run();
            long end = System.nanoTime();
            totalNanos += end - start;
        }

        return totalNanos / (double) RUNS / 1_000_000.0;
    }

    public static String format(double millis) {
        return String.format(Locale.US, "%.3f", millis);
    }
}