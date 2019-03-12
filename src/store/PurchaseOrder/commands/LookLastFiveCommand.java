package store.PurchaseOrder.commands;

import store.GoodsStoreBasket;

public class LookLastFiveCommand extends BaseChain {
    private final GoodsStoreBasket basket;

    public LookLastFiveCommand(BaseChain next, String code, GoodsStoreBasket basket) {
        super(next, code);
        this.basket = basket;
    }

    @Override
    protected boolean execute() {
        basket.lookLastFiveGoods();
        return true;
    }

    @Override
    protected void printCommandGoal() {
        System.out.println("Введите last + enter для просмотра информации о 5 последних добавленных таварах.");
    }
}
