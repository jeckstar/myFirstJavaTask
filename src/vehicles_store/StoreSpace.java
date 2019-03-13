package vehicles_store;

import vehicles_store.PurchaseOrder.Orders;
import vehicles_store.PurchaseOrder.commands.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StoreSpace {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final ChainMaster commandsSequence = createCommandsSequence();
        //commandsSequence.printCommandsSequence();
        while (waitForTheNextCommand(reader, commandsSequence)) {
////            if (command.equals("exit")) break;
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

    private static ChainMaster createCommandsSequence() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        GoodsStoreBasket storeBasket = new GoodsStoreBasket();
        VehicleStore vehicleStore = new VehicleStore();
        Orders orders = new Orders();
        PrinterOfStore printer = new PrinterOfStore();
        final СlosestOrderCommand closest = new СlosestOrderCommand(BaseChain.NO_OP_CHAIN, "closestOrder", orders);
        final BreakCommand breakCommand = new BreakCommand(closest, "exit");
        final LookLastFiveCommand last = new LookLastFiveCommand(breakCommand, "last", storeBasket);
        final ShowOrderInTimeLineCommand orderTime = new ShowOrderInTimeLineCommand(last, "orderTime", orders);
        final ShowOrderListCommand order = new ShowOrderListCommand(orderTime, "orderList", orders);
        final MakeOrderCommand orderCommand = new MakeOrderCommand(order, "order", storeBasket, orders, printer);
        final RemoveFromBasketCommand remove = new RemoveFromBasketCommand(orderCommand, "car", storeBasket, reader);
        final AddProductToBasketCommand add = new AddProductToBasketCommand(remove, "add", vehicleStore, storeBasket, reader);
        final BuyProductsCommand buy = new BuyProductsCommand(add, "buy", storeBasket);
        final ShowBasketCommand showBasketCommand = new ShowBasketCommand(buy, "2", storeBasket);
        return new ShowProductsCommand(showBasketCommand, "1", vehicleStore);
    }

}
