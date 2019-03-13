package text_reader.file_search.file_filter_config;

import java.io.BufferedReader;
import java.io.IOException;

public class SizeRangeFilterConfig extends BaseFilterConfig {
    private final BufferedReader reader;
    private final FilterConfig config;

    public SizeRangeFilterConfig(BaseFilterConfig next, BufferedReader reader, FilterConfig config) {
        super(next);
        this.reader = reader;
        this.config = config;
    }

    @Override
    protected boolean execute() {
        try {
            System.out.println("Введите диапазону размеров файла:");
            String line = reader.readLine();
            long size = Long.parseLong(line);
            System.out.println(size);
            config.setSize(size);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    protected void printCommandGoal() {
        System.out.println("> искать диапазону размеров файла ? (0/1)");
    }
}
