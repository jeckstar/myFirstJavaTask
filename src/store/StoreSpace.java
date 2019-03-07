package store;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StoreSpace {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        VehicleStore vehicleStore = new VehicleStore();
        GoodsStoreBasket storeBasket = new GoodsStoreBasket();
        PrinterOfStore printer = new PrinterOfStore();
        printer.menu();
        while (true) {
            String command = reader.readLine();
            if (command.equals("1")) {
                vehicleStore.printStoreList();
            }
            if (command.equals("2")) {
                storeBasket.printBasketList();
            }
            if (command.equals("add")) {
                vehicleStore.listOfItem();
                BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
                String innerCommand = reader2.readLine();
                storeBasket.addVehicle(vehicleStore, innerCommand);
            }
            if (command.equals("car")) {
                storeBasket.printBeforeRemove();
                BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
                String innerCommand = reader2.readLine();
                storeBasket.removeVehicle(storeBasket, innerCommand);
                if (innerCommand.equals("0")) {
                    printer.menu();
                }
            }
            if (command.equals("-1")) break;
        }
    }
}
