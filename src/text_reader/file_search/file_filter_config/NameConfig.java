package text_reader.file_search.file_filter_config;

import text_reader.file_search.FilteredFileList;
import text_reader.file_search.file_filter_config.ConfigFilter.AddConfig;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class NameConfig extends BaseFilter {
    private final BufferedReader reader;
    private final AddConfig addConfig;

    public NameConfig(BaseFilter next, BufferedReader reader, AddConfig addConfig) {
        super(next);
        this.reader = reader;
        this.addConfig = addConfig;
    }

    @Override
    protected boolean execute() {
        try {
            System.out.println("Введите имя файла:");
            String line = reader.readLine();
            System.out.println(line);
            addConfig.setName(line);
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
