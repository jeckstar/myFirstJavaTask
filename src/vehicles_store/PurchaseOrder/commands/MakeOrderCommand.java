package vehicles_store.PurchaseOrder.commands;

import vehicles_store.GoodsStoreBasket;
import vehicles_store.PrinterOfStore;
import vehicles_store.PurchaseOrder.Orders;

import java.io.IOException;
import java.text.ParseException;


public class MakeOrderCommand extends BaseChain{
    private final GoodsStoreBasket basket;
    private final Orders orders;
    private final PrinterOfStore printer;

    public MakeOrderCommand(BaseChain next, String code, GoodsStoreBasket basket, Orders orders, PrinterOfStore printer) {
        super(next, code);
        this.basket = basket;
        this.orders = orders;
        this.printer = printer;
    }

    @Override
    protected boolean execute() {
        if (basket.getBasket().isEmpty())
            basket.printBasketListBeforeCopy();
        else {
            try {
                orders.addNewOrder(basket);
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
            printer.orderIsReady();
        }
        return true;
    }

    @Override
    protected void printCommandGoal() {
        System.out.println("Введите order + enter для оформления заказа.");
    }
}
