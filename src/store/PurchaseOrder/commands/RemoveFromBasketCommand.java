package store.PurchaseOrder.commands;

import store.GoodsStoreBasket;

import java.io.BufferedReader;
import java.io.IOException;

public class RemoveFromBasketCommand extends BaseChain {
    private final GoodsStoreBasket basket;
    private final BufferedReader reader;



    public RemoveFromBasketCommand (BaseChain next, String code, GoodsStoreBasket basket, BufferedReader reader) {
        super(next, code);
        this.basket = basket;
        this.reader = reader;
    }

    @Override
    protected void execute() {
        basket.printBeforeRemove();
        String innerCommand = null;
        if (!basket.getBasket().isEmpty()) {
            try {
                innerCommand = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            basket.removeVehicle(basket, innerCommand);
        }
    }

    @Override
    protected void printCommandGoal() {
        System.out.println("Введите car + enter для удаления из корзины.");
    }
}
