package text_reader.file_search.file_filter_config;

import text_reader.file_search.FilteredFileList;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class NameFilterConfig extends BaseFilterConfig {
    private final BufferedReader reader;
    private final FilterConfig config;
    private final FilteredFileList filteredFileList = null;
    private final File[] filesInCatalog = null;

    public NameFilterConfig(BaseFilterConfig next, BufferedReader reader, FilterConfig config) {
        super(next);
        this.reader = reader;
        this.config = config;
    }

    @Override
    protected boolean execute() {
        try {
            System.out.println("Введите имя файла:");
            String line = reader.readLine();
            config.setName(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    protected void printCommandGoal() {
        System.out.println("> искать по имени файла ? (0/1)");
    }
}
