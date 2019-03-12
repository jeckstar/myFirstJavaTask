package store.PurchaseOrder.commands;

import store.PurchaseOrder.DateOfOrder;
import store.PurchaseOrder.Orders;
import store.Vehicle;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

public class ShowOrderInTimeLineCommand extends BaseChain {
    private final Orders orders;

    public ShowOrderInTimeLineCommand(BaseChain next, String code, Orders orders) {
        super(next, code);
        this.orders = orders;
    }

    @Override
    protected void execute() {
        if (!orders.getInnerTreeMap().isEmpty()) {
            try {
                DateOfOrder from = new DateOfOrder();
                DateOfOrder to = new DateOfOrder();
                for (Map.Entry<DateOfOrder, List<Vehicle>> entry : orders.getInnerTreeMap().entrySet()) {
                    DateOfOrder key = entry.getKey();
                    List<Vehicle> value = entry.getValue();
                    if (key.compareTo(from) > -1 && key.compareTo(to) < 1) {
                        System.out.println("Заказы в заданом диапазоне:\n" +
                                "Дата заказа - " + key + "\n" +
                                "Ваш заказ:");
                        for (int i = 0; i < value.size(); i++) {
                            System.out.println(value.get(i));
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else System.out.println("Список заказов пуст.");

    }

    @Override
    protected void printCommandGoal() {
        System.out.println("Введите orderTime + enter для просмотра заказа.");
    }
}
