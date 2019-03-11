package store;

import store.PurchaseOrder.DateOfOrder;
import store.PurchaseOrder.OrderList;
import store.PurchaseOrder.Orders;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StoreSpace {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        VehicleStore vehicleStore = new VehicleStore();
        GoodsStoreBasket storeBasket = new GoodsStoreBasket();
        PrinterOfStore printer = new PrinterOfStore();
        Orders orders = new Orders();
        printer.menu();
        while (true) {
            String command = reader.readLine();
            if (command.equals("1")) {
                vehicleStore.printStoreList();
            }
            if (command.equals("2")) {
                storeBasket.printBasketList();
            }
            if (command.equals("buy")) {
                storeBasket.buyBasketContents();
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
            }
            if (command.equals("order")) {
                if (storeBasket.getBasket().isEmpty())
                storeBasket.printBasketListBeforeCopy();
                else {
                orders.addNewOrder(storeBasket);
                printer.orderIsReady();
                printer.menu();
                }
            }
            if (command.equals("orderList")) orders.printAllOrders();
            if (command.equals("orderTime")){

            }
            if (command.equals("last")) storeBasket.lookLastFiveGoods();
            if (command.equals("menu")) printer.menu();
            if (command.equals("-1")) break;
        }
    }
}
