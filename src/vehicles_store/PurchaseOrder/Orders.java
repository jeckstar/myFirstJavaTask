package vehicles_store.PurchaseOrder;

import vehicles_store.GoodsStoreBasket;
import vehicles_store.PrinterOfStore;
import vehicles_store.Vehicle;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Orders {

    private TreeMap<DateOfOrder, List<Vehicle>> innerTreeMap = new TreeMap<>();
    private PrinterOfStore printer = new PrinterOfStore();

    public List<CompletedOrder> getAllOrdersInformation() {
        return innerTreeMap.entrySet()
                .stream()
                .map(CompletedOrder::new)
                .collect(Collectors.toList());
    }

    public void addNewOrder(GoodsStoreBasket storeBasket) throws IOException, ParseException{
        OrderList listOfOrders = new OrderList();
        listOfOrders.addToOrderList(storeBasket);
        innerTreeMap.put(listOfOrders.getDateOfOrder(), listOfOrders.getInnerList());
    }

    public void printAllOrders() {
        printer.printThisTreeMap(this.innerTreeMap);

    }

    public boolean isEmpty(){
        return innerTreeMap.isEmpty();
    }

}
