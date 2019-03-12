package store.PurchaseOrder.commands;

import store.PurchaseOrder.DateOfOrder;
import store.PurchaseOrder.Orders;
import store.Vehicle;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class СlosestOrderCommand extends BaseChain {
    private final Orders orders;

    public СlosestOrderCommand(BaseChain next, String code, Orders orders) {
        super(next, code);
        this.orders = orders;
    }

    @Override
    protected boolean execute() {
        if (!orders.getInnerTreeMap().isEmpty()) {
            try {
                List<DateOfOrder> datelist = new ArrayList<>();
                DateOfOrder closestDate = new DateOfOrder();
                for (Map.Entry<DateOfOrder, List<Vehicle>> entry : orders.getInnerTreeMap().entrySet()) {
                    DateOfOrder key = entry.getKey();
                    List<Vehicle> value = entry.getValue();
                    datelist.add(key);
                }
                DateOfOrder closestKey = null;
                for (int i = datelist.size()-1; i > 0 ; i--) {
                    if (closestDate.compareTo(datelist.get(i)) > -1) {
                        closestKey = datelist.get(i);
                        break;
                    }
                    else closestKey = datelist.get(0);

                }

                System.out.println("Ближайший заказ - " + closestKey + "\n" +
                        "Ваш заказ:");
                List<Vehicle> vehicles = orders.getInnerTreeMap().get(closestKey);
                for (Vehicle vehicle : vehicles) {
                    System.out.println(vehicle);
                }
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
        } else System.out.println("Список заказов пуст.");

        return true;
    }

    @Override
    protected void printCommandGoal() {
        System.out.println("Введите closestOrder + enter для просмотра заказа.");
    }
}

