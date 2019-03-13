package text_reader.file_search.file_filter_config;

import text_reader.file_search.FilteredFileList;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class NameFilter extends BaseFilter {
    private final BufferedReader reader;
    private final FilteredFileList filteredFileList = null;
    private final File[] filesInCatalog = null;

    public NameFilter(BaseFilter next, BufferedReader reader) {
        super(next);
        this.reader = reader;
    }

    @Override
    protected void execute() {
        try {
            System.out.println("Введите имя файла:");
            String line = reader.readLine();
            System.out.println(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void printCommandGoal() {
        System.out.println("> искать по имени файла ? (0/1)");
    }
}
