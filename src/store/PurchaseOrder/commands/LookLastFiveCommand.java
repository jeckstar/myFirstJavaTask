package store.PurchaseOrder.commands;

import store.GoodsStoreBasket;

public class LookLastFiveCommand extends BaseChain {
    private final GoodsStoreBasket basket;

    public LookLastFiveCommand(BaseChain next, String code, GoodsStoreBasket basket) {
        super(next, code);
        this.basket = basket;
    }

    @Override
    protected void execute() {
        basket.lookLastFiveGoods();
    }

    @Override
    protected void printCommandGoal() {
        System.out.println("Для просмотра информации о 5 последних добавленных таварах введите last + enter");
    }
}
