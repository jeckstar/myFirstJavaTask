package text_reader.file_search.file_filter_config;

import text_reader.file_search.file_filter_config.ConfigFilter.AddConfig;

import java.io.BufferedReader;
import java.io.IOException;

public class DateRangeConfig extends BaseFilter {
    private final BufferedReader reader;
    private final AddConfig addConfig;


    public DateRangeConfig(BaseFilter next, BufferedReader reader, AddConfig addConfig) {
        super(next);
        this.reader = reader;
        this.addConfig = addConfig;
    }

    @Override
    protected boolean execute() {
        try {
            System.out.println("Введите диапазон дат изменения файла:\n" +
                    "от:");
            String line = reader.readLine();
            System.out.println(line);
            long fromDate = Long.parseLong(line);
            addConfig.setFromDate(fromDate);
            System.out.println("до:");
            String line2 = reader.readLine();
            System.out.println(line2);
            long toDate = Long.parseLong(line2);
            addConfig.setToDate(toDate);
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
