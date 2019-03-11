package store.PurchaseOrder.commands;

import store.GoodsStoreBasket;
import store.PrinterOfStore;
import store.PurchaseOrder.Orders;

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
    protected void execute() {
        if (basket.getBasket().isEmpty())
            basket.printBasketListBeforeCopy();
        else {
            try {
                orders.addNewOrder(basket);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            printer.orderIsReady();
        }
    }

    @Override
    protected void printCommandGoal() {
        System.out.println("Для оформления заказа введите order + enter");
    }
}
