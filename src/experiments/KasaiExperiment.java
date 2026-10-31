package experiments;

import suffix.KasaiLcp;
import suffix.SuffixArrayBuilder;

import java.util.ArrayList;
import java.util.List;

public class KasaiExperiment {

    private static final int[] SIZES = {1000, 5000, 10000};

    public List<String> run() {
        List<String> rows = new ArrayList<>();
        rows.add("length,kasai_ms");

        SuffixArrayBuilder builder = new SuffixArrayBuilder();
        KasaiLcp kasai = new KasaiLcp();
        RandomTextGenerator generator = new RandomTextGenerator();

        for (int size : SIZES) {
            String text = generator.generate(size);
            int[] suffixArray = builder.build(text);

            double time = Timer.averageMillis(() -> kasai.build(text, suffixArray));

            rows.add(size + "," + Timer.format(time));
        }

        return rows;
    }
}