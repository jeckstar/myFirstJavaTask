package store.PurchaseOrder;

import store.GoodsStoreBasket;
import store.StoreSpace;
import store.Vehicle;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderList {
    private List<Vehicle> innerList;
    private DateOfOrder dateOfOrder;

    public OrderList() throws IOException, ParseException {
        dateOfOrder = new DateOfOrder();
        innerList = new ArrayList<>();
    }

    public boolean addToOrderList(GoodsStoreBasket goodsStoreBasket) {
        Map<Vehicle, Integer> basket = goodsStoreBasket.getBasket();
        for (Map.Entry<Vehicle, Integer> entry : basket.entrySet()) {
            Vehicle key = entry.getKey();
            Integer value = entry.getValue();
            if (value > 1) {
                while (value > 0) {
                    innerList.add(key);
                    value--;
                }
            } else innerList.add(key);
        }
        return !basket.isEmpty();
    }

    public DateOfOrder getDateOfOrder() {
        return dateOfOrder;
    }

    public List<Vehicle> getInnerList() {
        return innerList;
    }

}
