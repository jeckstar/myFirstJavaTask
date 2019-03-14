package text_reader.file_search.file_filter_config.ConfigFilter;

import vehicles_store.PurchaseOrder.DateOfOrder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LastModDate {
    private Date fromThisDate;
    private Date toThisDate;

    public LastModDate() throws IOException, ParseException {
        System.out.println("Введите дату в формате < yyyy-MM-dd HH:mm:ss.S > в диапазоне с 2010-01-10 00:00:00.0 по 2100-12-31 00:00:00.0");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String dateFrom = reader.readLine();
        String dateTo = reader.readLine();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
        String from = "2010-01-10 00:00:00.0";
        String last = "2100-12-31 00:00:00.0";
        Date fromDate = s.parse(from);
        Date lastDate = s.parse(last);
        if (s.parse(dateFrom).compareTo(fromDate) >= 0  && s.parse(dateFrom).compareTo(lastDate) < 1 && s.parse(dateTo).compareTo(s.parse(dateFrom)) >=0 && s.parse(dateTo).compareTo(lastDate) <= 0) {
            fromThisDate = s.parse(dateFrom);
            toThisDate = s.parse(dateTo);
            System.out.println("Вы ввели - " + s.format(fromThisDate));
            System.out.println("Вы ввели - " + s.format(toThisDate));
        } else {
            System.out.println("Вы ввели неверный формат даты, повторите ввод.");
        }
    }

    public Date getFromThisDate() {
        return fromThisDate;
    }

    public Date getToThisDate() {
        return toThisDate;
    }

    @Override
    public String toString() {
        SimpleDateFormat s = new SimpleDateFormat("01.01.2100 00:00:00");
        return s.format(this);
    }

}