package experiments;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        saveAndPrint("lcs_edit_distance.csv", new DynamicProgrammingExperiment().run());
        saveAndPrint("string_matching.csv", new StringMatchingExperiment().run());
        saveAndPrint("kasai.csv", new KasaiExperiment().run());
    }

    private static void saveAndPrint(String fileName, List<String> rows) throws IOException {
        Files.createDirectories(Path.of("results"));
        Files.write(Path.of("results", fileName), rows);

        System.out.println(fileName);
        for (String row : rows) {
            System.out.println(row);
        }
        System.out.println();
    }
}