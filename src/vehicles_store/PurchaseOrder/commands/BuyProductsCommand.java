package vehicles_store.PurchaseOrder.commands;

import vehicles_store.GoodsStoreBasket;

public class BuyProductsCommand extends BaseChain {
    private final GoodsStoreBasket basket;


    public BuyProductsCommand(BaseChain next, String code, GoodsStoreBasket basket) {
        super(next, code);
        this.basket = basket;
    }

    @Override
    protected boolean execute() {
        basket.buyBasketContents();
        return true;
    }

    @Override
    protected void printCommandGoal() {
        System.out.println("Введите buy + enter для покупки товаров из корзины.");
    }
}
