package store.PurchaseOrder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateOfOrder implements Comparable<DateOfOrder> {
    private Date orderDay;

    public DateOfOrder() throws IOException, ParseException {
        System.out.println("Введите дату в формате dd.MM.yyyy");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String date = reader.readLine();
        SimpleDateFormat s = new SimpleDateFormat("dd.MM.yyyy");
        orderDay = s.parse(date);
        System.out.println(s.format(orderDay));
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

    public static void main(String[] args) throws NullPointerException{
        DateOfOrder n = null;
        DateOfOrder n2 = null;
        try {
            n = new DateOfOrder();
        } catch (IOException e) {
            System.out.println("Так не пойдет - IOException, бро");
        } catch (ParseException e) {
            System.out.println("Так не пойдет - ParseException, бро");
        }
        try {
            n2 = new DateOfOrder();
        } catch (IOException e) {
            System.out.println("Так не пойдет - IOException, бро");
        } catch (ParseException e) {
            System.out.println("Так не пойдет - ParseException, бро");
        }
        System.out.println(n.compareTo(n2));


    }

}