package text_reader.file_search.file_filter_config;

import java.io.BufferedReader;
import java.io.IOException;

public class SizeRangeFilter extends BaseFilter {
    private final BufferedReader reader;

    public SizeRangeFilter(BaseFilter next, BufferedReader reader) {
        super(next);
        this.reader = reader;
    }

    @Override
    protected void execute() {
        try {
            System.out.println("Введите диапазону размеров файла:");
            String line = reader.readLine();
            System.out.println(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void printCommandGoal() {
        System.out.println("> искать диапазону размеров файла ? (0/1)");
    }
}
