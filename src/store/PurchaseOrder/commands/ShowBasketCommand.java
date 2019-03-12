package store.PurchaseOrder.commands;

import store.GoodsStoreBasket;

public class ShowBasketCommand extends BaseChain {

    private final GoodsStoreBasket basket;


    public ShowBasketCommand(BaseChain next, String code, GoodsStoreBasket basket) {
        super(next, code);
        this.basket = basket;
    }

    @Override
    protected boolean execute() {
        basket.printBasketList();
        return true;
    }

    @Override
    protected void printCommandGoal() {
        System.out.println("Введите 2 + enter для просмотра корзины.");
    }
}
