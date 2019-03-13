package text_reader.file_search.file_filter;

import java.io.BufferedReader;
import java.io.IOException;

public class DateRangeFilter extends BaseFilter {
    private final BufferedReader reader;

    public DateRangeFilter(BaseFilter next, BufferedReader reader) {
        super(next);
        this.reader = reader;
    }

    @Override
    protected boolean execute() {
        try {
            System.out.println("Введите диапазон дат изменения файла:");
            String line = reader.readLine();
            System.out.println(line);
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
