package text_reader.file_search.file_filter_config;

import text_reader.file_search.file_filter_config.ConfigFilter.AddConfig;
import text_reader.file_search.file_filter_config.ConfigFilter.LastModDate;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;

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
            LastModDate lastModDate = new LastModDate();
            addConfig.setFromDate(lastModDate.getFromThisDate());
            addConfig.setToDate(lastModDate.getToThisDate());
        } catch (ParseException e) {
            e.printStackTrace();
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
