package text_reader.file_search.file_filter_config;

import java.io.BufferedReader;
import java.io.IOException;

public class FileExtensionFilter extends BaseFilter {
    private final BufferedReader reader;

    public FileExtensionFilter(BaseFilter next, BufferedReader reader) {
        super(next);
        this.reader = reader;
    }

    @Override
    protected void execute() {
        try {
            System.out.println("Введите расширение файла:");
            String line = reader.readLine();
            System.out.println(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void printCommandGoal() {
        System.out.println("> искать по расширению файла ? (0/1)");
    }
}
