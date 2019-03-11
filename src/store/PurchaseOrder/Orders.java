package store.PurchaseOrder;

import store.GoodsStoreBasket;
import store.PrinterOfStore;
import store.Vehicle;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Orders {
    private TreeMap<DateOfOrder, List<Vehicle>> innerTreeMap = new TreeMap<>();
    private PrinterOfStore printer = new PrinterOfStore();




    public void addNewOrder(GoodsStoreBasket storeBasket) throws IOException, ParseException{
        OrderList listOfOrders = new OrderList();
        listOfOrders.addToOrderList(storeBasket);
        innerTreeMap.put(listOfOrders.getDateOfOrder(), listOfOrders.getInnerList());
    }

    public void printAllOrders() {
        printer.printThisTreeMap(this.innerTreeMap);

    }

}
