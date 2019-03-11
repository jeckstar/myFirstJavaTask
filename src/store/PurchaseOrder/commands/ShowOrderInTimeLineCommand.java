package store.PurchaseOrder.commands;

import store.PurchaseOrder.Orders;

public class ShowOrderInTimeLineCommand extends BaseChain {
    private final Orders orders;

    public ShowOrderInTimeLineCommand(BaseChain next, String code, Orders orders) {
        super(next, code);
        this.orders = orders;
    }

    @Override
    protected void execute() {

    }

    @Override
    protected void printCommandGoal() {
        System.out.println("Введите orderTime + enter для просмотра заказа.");
    }
}
