package text_reader.file_search.file_filter_config;

import java.io.BufferedReader;
import java.io.IOException;

public class DateRangeFilterConfig extends BaseFilterConfig {
    private final BufferedReader reader;
    private final FilterConfig config;

    public DateRangeFilterConfig(BaseFilterConfig next, BufferedReader reader, FilterConfig config) {
        super(next);
        this.reader = reader;
        this.config = config;
    }

    @Override
    protected boolean execute() {
        try {
            System.out.println("Введите диапазон дат изменения файла:");
            String line = reader.readLine();
            long date = Long.parseLong(line);
            System.out.println(line);
            config.setDate(date);
            config.print();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    protected void printCommandGoal() {
        System.out.println("> искать по диапазону дат изменения файла ? (0/1)");
    }
}
