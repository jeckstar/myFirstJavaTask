package store;

import store.PurchaseOrder.DateOfOrder;
import store.PurchaseOrder.OrderList;
import store.PurchaseOrder.Orders;
import store.PurchaseOrder.commands.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StoreSpace {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final ChainMaster commandsSequence = createCommandsSequence();
        //commandsSequence.printCommandsSequence();
        while (true) {
            System.out.println();
            commandsSequence.printCommandsSequence();
            String command = reader.readLine();
            commandsSequence.handleCommand(command);

////            if (command.equals("exit")) break;
        }
    }

    private static ChainMaster createCommandsSequence() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        GoodsStoreBasket storeBasket = new GoodsStoreBasket();
        VehicleStore vehicleStore = new VehicleStore();
        Orders orders = new Orders();
        PrinterOfStore printer = new PrinterOfStore();
        final BreakCommand breakCommand = new BreakCommand(BaseChain.NO_OP_CHAIN,"exit");
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
