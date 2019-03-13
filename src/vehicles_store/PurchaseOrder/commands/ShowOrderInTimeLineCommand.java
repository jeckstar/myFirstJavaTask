package vehicles_store.PurchaseOrder.commands;

import vehicles_store.PurchaseOrder.CompletedOrder;
import vehicles_store.PurchaseOrder.DateOfOrder;
import vehicles_store.PurchaseOrder.Orders;
import vehicles_store.Vehicle;

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
    protected boolean execute() {
        if (!orders.isEmpty()) {
            try {
                DateOfOrder from = new DateOfOrder();
                DateOfOrder to = new DateOfOrder();
                for (CompletedOrder completedOrder : orders.getAllOrdersInformation()) {
                    if (completedOrder.getDate().compareTo(from) > -1 && completedOrder.getDate().compareTo(to) < 1) {
                        System.out.println("Заказы в заданом диапазоне:\n" +
                                "Дата заказа - " + completedOrder.getDate() + "\n" +
                                "Ваш заказ:");
                        for (Vehicle vehicle : completedOrder.getVehicles()) {
                            System.out.println(vehicle);
                        }
                    }
                }
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
        } else System.out.println("Список заказов пуст.");

        return true;
    }

    @Override
    protected void printCommandGoal() {
        System.out.println("Введите orderTime + enter для просмотра заказа.");
    }
}
