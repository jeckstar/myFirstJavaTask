package text_reader.file_search.file_filter;

import java.io.BufferedReader;

public class SizeRangeFilter extends BaseFilter {
    private final BufferedReader reader;

    public SizeRangeFilter(BaseFilter next, BufferedReader reader) {
        super(next);
        this.reader = reader;
    }

    @Override
    protected boolean execute() {
        return true;
    }

    @Override
    protected void printCommandGoal() {
        System.out.println("> искать диапазону размеров файла ? (0/1)");
    }
}
