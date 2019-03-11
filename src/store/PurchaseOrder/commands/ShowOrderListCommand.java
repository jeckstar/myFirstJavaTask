package store.PurchaseOrder.commands;

import store.PurchaseOrder.Orders;

public class ShowOrderListCommand extends BaseChain {
    private final Orders orders;

    public ShowOrderListCommand(BaseChain next, String code, Orders orders) {
        super(next, code);
        this.orders = orders;
    }

    @Override
    protected void execute() {
        orders.printAllOrders();
    }

    @Override
    protected void printCommandGoal() {
        System.out.println("Введите orderList + enter для просмотра заказа.");
    }
}
