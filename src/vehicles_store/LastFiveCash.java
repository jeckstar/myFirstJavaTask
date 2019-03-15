package vehicles_store;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class LastFiveCash extends LinkedHashMap<Integer, Vehicle> implements Serializable {

    private int id;

    public void add(Vehicle vehicle) {
        put(id++, vehicle);
    }

    public void lastFiveGoods() {
        values().forEach(System.out::println);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Vehicle> eldest) {
        return size() > 5;
    }
}
