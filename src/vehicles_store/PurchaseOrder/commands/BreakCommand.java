package vehicles_store.PurchaseOrder.commands;

import goods_container_sever.EasyConteinerReaderAndSaver;
import vehicles_store.GoodsStoreBasket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BreakCommand extends BaseChain {
    private EasyConteinerReaderAndSaver easyConteinerReaderAndSaver = new EasyConteinerReaderAndSaver();
    private final GoodsStoreBasket storeBasket;


    public BreakCommand(BaseChain next, String code, GoodsStoreBasket storeBasket) {
        super(next, code);
        this.storeBasket = storeBasket;
    }

    @Override
    protected boolean execute() {
        try {
            easyConteinerReaderAndSaver.saveBasket(storeBasket);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("До встречи!");
        return false;
    }

    @Override
    protected void printCommandGoal() {
        System.out.println("Введите exit + enter для выхода из магазина.");
    }
}
