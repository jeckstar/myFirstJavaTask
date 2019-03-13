package text_reader.file_search.file_filter_config;

import java.io.BufferedReader;
import java.io.IOException;

public class FileExtensionFilterConfig extends BaseFilterConfig {
    private final BufferedReader reader;
    private final FilterConfig config;

    public FileExtensionFilterConfig(BaseFilterConfig next, BufferedReader reader, FilterConfig config) {
        super(next);
        this.reader = reader;
        this.config = config;
    }

    @Override
    protected boolean execute() {
        try {
            System.out.println("Введите расширение файла:");
            String line = reader.readLine();
            System.out.println(line);
            config.setExtension(line);
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
