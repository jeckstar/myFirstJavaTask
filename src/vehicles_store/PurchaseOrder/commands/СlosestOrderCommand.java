package vehicles_store.PurchaseOrder.commands;

import vehicles_store.PurchaseOrder.CompletedOrder;
import vehicles_store.PurchaseOrder.DateOfOrder;
import vehicles_store.PurchaseOrder.Orders;
import vehicles_store.Vehicle;

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
        if (!orders.isEmpty()) {
            try {
                final List<CompletedOrder> allOrdersInformation = orders.getAllOrdersInformation();
                DateOfOrder closestDate = new DateOfOrder();
                CompletedOrder closestOrder = null;
                for (int i = allOrdersInformation.size() - 1; i > 0; i--) {
                    if (closestDate.compareTo(allOrdersInformation.get(i).getDate()) > -1) {
                        closestOrder = allOrdersInformation.get(i);
                        break;
                    } else {
                        closestOrder = allOrdersInformation.get(0);
                    }

                }
                System.out.println("Ближайший заказ - " + closestOrder.getDate() + "\n" +
                        "Ваш заказ:");

                for (Vehicle vehicle : closestOrder.getVehicles()) {
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

