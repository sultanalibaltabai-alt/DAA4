package matching;

import java.util.List;

public interface StringSearcher {

    List<Integer> search(String text, String pattern);

    long getComparisons();

    String getName();
}