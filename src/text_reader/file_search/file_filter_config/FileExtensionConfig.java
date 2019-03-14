package text_reader.file_search.file_filter_config;

import text_reader.file_search.file_filter_config.ConfigFilter.AddConfig;

import java.io.BufferedReader;
import java.io.IOException;

public class FileExtensionConfig extends BaseFilter {
    private final BufferedReader reader;
    private final AddConfig addConfig;

    public FileExtensionConfig(BaseFilter next, BufferedReader reader, AddConfig addConfig) {
        super(next);
        this.reader = reader;
        this.addConfig = addConfig;
    }

    @Override
    protected boolean execute() {
        try {
            System.out.println("Введите расширение файла:");
            String line = reader.readLine();
            System.out.println(line);
            addConfig.setType(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    protected void printCommandGoal() {
        System.out.println("> искать по расширению файла ? (0/1)");
    }
}
