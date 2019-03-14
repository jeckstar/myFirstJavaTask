package text_reader.file_search.file_filter_config;

import text_reader.file_search.file_filter_config.ConfigFilter.AddConfig;

import java.io.BufferedReader;
import java.io.IOException;

public class SizeRangeConfig extends BaseFilter {
    private final BufferedReader reader;
    private final AddConfig addConfig;


    public SizeRangeConfig(BaseFilter next, BufferedReader reader, AddConfig addConfig) {
        super(next);
        this.reader = reader;
        this.addConfig = addConfig;
    }

    @Override
    protected boolean execute() {
        try {
            System.out.println("Введите диапазон размеров файла в килобайтах:\n" +
                    "от килобайт:");
            String line = reader.readLine();
            System.out.println(line + " килобайт");
            long fromSize = Long.parseLong(line);
            addConfig.setFromSize(1024 * fromSize);
            System.out.println("до килобайт:");
            String line2 = reader.readLine();
            System.out.println(line2 + " килобайт");
            long toSize = Long.parseLong(line2);
            addConfig.setToSize(1024 * toSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    protected void printCommandGoal() {
        System.out.println("> искать диапазону размеров файла ? (0/1)");
    }
}
