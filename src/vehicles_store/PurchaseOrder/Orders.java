package vehicles_store.PurchaseOrder;

import vehicles_store.GoodsStoreBasket;
import vehicles_store.PrinterOfStore;
import vehicles_store.Vehicle;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.TreeMap;

public class Orders {
    private TreeMap<DateOfOrder, List<Vehicle>> innerTreeMap = new TreeMap<>();
    private PrinterOfStore printer = new PrinterOfStore();


    public TreeMap<DateOfOrder, List<Vehicle>> getInnerTreeMap() {
        return innerTreeMap;
    }

    public void addNewOrder(GoodsStoreBasket storeBasket) throws IOException, ParseException{
        OrderList listOfOrders = new OrderList();
        listOfOrders.addToOrderList(storeBasket);
        innerTreeMap.put(listOfOrders.getDateOfOrder(), listOfOrders.getInnerList());
    }

    public void printAllOrders() {
        printer.printThisTreeMap(this.innerTreeMap);

    }

}
