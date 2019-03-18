package vehicles_store;

import goods_container_sever.EasyConteinerReaderAndSaver;
import vehicles_store.PurchaseOrder.Orders;
import vehicles_store.PurchaseOrder.commands.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StoreSpace {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final ChainMaster commandsSequence = createCommandsSequence();
        while (waitForTheNextCommand(reader, commandsSequence)) {
        }
    }

    private static boolean waitForTheNextCommand(BufferedReader reader, ChainMaster commandsSequence) throws IOException {
        System.out.println();
        commandsSequence.printCommandsSequence();
        String command = reader.readLine();
        try {
            return commandsSequence.handleCommand(command);
        } catch (NoSuchCommandException e) {
            System.out.println("ERROR! Команда введена неверно! Введите корректную команду.");
            return true;
        }
    }

    private static ChainMaster createCommandsSequence() throws IOException, ClassNotFoundException {
        LastFiveCash lastFiveCash = new LastFiveCash();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        EasyConteinerReaderAndSaver easyGoodsContainer = new EasyConteinerReaderAndSaver();
        GoodsStoreBasket storeBasket = easyGoodsContainer.readBasket();
        VehicleStore vehicleStore = new VehicleStore();
        Orders orders = new Orders();
        PrinterOfStore printer = new PrinterOfStore();
        final AddNewGoodsInStoreCatalogCommand addNew = new AddNewGoodsInStoreCatalogCommand(BaseChain.NO_OP_CHAIN, "newGoods", vehicleStore, reader);
        final СlosestOrderCommand closest = new СlosestOrderCommand(addNew, "closestOrder", orders);
        final BreakCommand breakCommand = new BreakCommand(closest, "exit", storeBasket);
        final LookLastFiveCommand last = new LookLastFiveCommand(breakCommand, "last", lastFiveCash);
        final ShowOrderInTimeLineCommand orderTime = new ShowOrderInTimeLineCommand(last, "orderTime", orders);
        final ShowOrderListCommand order = new ShowOrderListCommand(orderTime, "orderList", orders);
        final MakeOrderCommand orderCommand = new MakeOrderCommand(order, "order", storeBasket, orders, printer);
        final RemoveFromBasketCommand remove = new RemoveFromBasketCommand(orderCommand, "car", storeBasket, reader);
        final AddProductToBasketCommand add = new AddProductToBasketCommand(remove, "add", vehicleStore, storeBasket, reader, lastFiveCash);
        final BuyProductsCommand buy = new BuyProductsCommand(add, "buy", storeBasket);
        final ShowBasketCommand showBasketCommand = new ShowBasketCommand(buy, "2", storeBasket);
        return new ShowProductsCommand(showBasketCommand, "1", vehicleStore);
    }

}
