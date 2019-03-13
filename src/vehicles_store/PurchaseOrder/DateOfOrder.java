package vehicles_store.PurchaseOrder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateOfOrder implements Comparable<DateOfOrder> {
    private Date orderDay;

    public DateOfOrder() throws IOException, ParseException {
        System.out.println("Введите дату в формате dd.MM.yyyy в диапазоне с 01.03.2019 по 12.12.2022");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String date = reader.readLine();
        SimpleDateFormat s = new SimpleDateFormat("dd.MM.yyyy");
        String from = "01.03.2019";
        String last = "12.12.2022";
        Date fromDate = s.parse(from);
        Date lastDate = s.parse(last);
        if (s.parse(date).compareTo(fromDate) > -1 && s.parse(date).compareTo(lastDate) < 1) {
            orderDay = s.parse(date);
            System.out.println("Вы ввели - " + s.format(orderDay));
        } else {
            System.out.println("Вы ввели неверный формат даты, повторите ввод.");
        }
    }

    public Date getOrderDay() {
        return orderDay;
    }

    @Override
    public int compareTo(DateOfOrder o) {
        Date firstDay = this.getOrderDay();
        Date sacondDay = o.getOrderDay();
        return firstDay.compareTo(sacondDay);
    }

    @Override
    public String toString() {
        SimpleDateFormat s = new SimpleDateFormat("dd.MM.yyyy");
        return s.format(orderDay);
    }

}