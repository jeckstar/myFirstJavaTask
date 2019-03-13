package vehicles_store.PurchaseOrder.commands;

import vehicles_store.GoodsStoreBasket;
import vehicles_store.LastFiveCash;

public class LookLastFiveCommand extends BaseChain {
    private final LastFiveCash lastFiveCash;

    public LookLastFiveCommand(BaseChain next, String code, LastFiveCash lastFiveCash) {
        super(next, code);
        this.lastFiveCash = lastFiveCash;
    }

    @Override
    protected boolean execute() {
        lastFiveCash.lookLastFiveGoods();
        return true;
    }

    @Override
    protected void printCommandGoal() {
        System.out.println("Введите last + enter для просмотра информации о 5 последних добавленных таварах.");
    }
}
