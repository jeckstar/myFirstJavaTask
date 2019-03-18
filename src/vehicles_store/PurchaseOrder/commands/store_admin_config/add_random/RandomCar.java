package vehicles_store.PurchaseOrder.commands.store_admin_config.add_random;

import vehicles_store.Car;

import java.util.HashMap;
import java.util.Map;

public class RandomCar {
    private Map<Integer, String> models = new HashMap<>();
    private Map<Integer, String> color = new HashMap<>();
    private Map<Integer, String> machineSeries = new HashMap<>();


    public RandomCar() {
        models.put(1, "BMW X5");
        models.put(2, "Subaru");
        models.put(3, "Suzuki");
        models.put(4, "Nissan");
        models.put(5, "Toyota");
        color.put(1, "Blue");
        color.put(2, "White");
        color.put(3, "Grey");
        color.put(4, "Blue");
        color.put(5, "Black");
        machineSeries.put(1, "A");
        machineSeries.put(2, "B");
        machineSeries.put(3, "C");
        machineSeries.put(4, "D");
        machineSeries.put(5, "F");
    }

    public Car getCar() {
        return new Car(models.get(randomCount()),color.get(randomCount()), (randomCount()*60), machineSeries.get(randomCount()), randomCount()*1500);
    }

    private int randomCount() {
        return (int) (1 + Math.random() * 5);
    }

}
