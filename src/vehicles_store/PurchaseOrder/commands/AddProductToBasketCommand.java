package vehicles_store.PurchaseOrder.commands;

import vehicles_store.GoodsStoreBasket;
import vehicles_store.LastFiveCash;
import vehicles_store.Vehicle;
import vehicles_store.VehicleStore;

import java.io.BufferedReader;
import java.io.IOException;

public class AddProductToBasketCommand extends BaseChain {
    private final VehicleStore vehicleStore;
    private final GoodsStoreBasket storeBasket;
    private final BufferedReader reader;
    private final LastFiveCash lastFiveCash;

    public AddProductToBasketCommand(BaseChain next, String code, VehicleStore vehicleStore, GoodsStoreBasket storeBasket, BufferedReader reader, LastFiveCash lastFiveCash) {
        super(next, code);
        this.vehicleStore = vehicleStore;
        this.storeBasket = storeBasket;
        this.reader = reader;
        this.lastFiveCash = lastFiveCash;
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
        Vehicle vehicle = storeBasket.addVehicle(vehicleStore, innerCommand);
        if (vehicle != null){
            lastFiveCash.lastFiveGoods(vehicle);
        }
        return true;
    }

    @Override
    protected void printCommandGoal() {
        System.out.println("Введите add + enter для покупки товара из корзины.");

    }
}
