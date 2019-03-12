package store.PurchaseOrder.commands;

import store.GoodsStoreBasket;
import store.VehicleStore;

import java.io.BufferedReader;
import java.io.IOException;

public class AddProductToBasketCommand extends BaseChain {
    private final VehicleStore vehicleStore;
    private final GoodsStoreBasket storeBasket;
    private final BufferedReader reader;

    public AddProductToBasketCommand(BaseChain next, String code, VehicleStore vehicleStore, GoodsStoreBasket storeBasket, BufferedReader reader) {
        super(next, code);
        this.vehicleStore = vehicleStore;
        this.storeBasket = storeBasket;
        this.reader = reader;
    }


    @Override
    protected boolean execute() {
        vehicleStore.listOfItem();
        String innerCommand = null;
        try {
            innerCommand = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        storeBasket.addVehicle(vehicleStore, innerCommand);
        return true;
    }

    @Override
    protected void printCommandGoal() {
        System.out.println("Введите add + enter для покупки товара из корзины.");

    }
}
