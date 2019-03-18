package vehicles_store.PurchaseOrder.commands.store_admin_config.add_random;

import vehicles_store.SuperCar;

import java.util.HashMap;
import java.util.Map;

public class RandomSuperCar {
    private Map<Integer, String> models = new HashMap<>();
    private Map<Integer, String> color = new HashMap<>();
    private Map<Integer, String> machineSeries = new HashMap<>();

    public RandomSuperCar( ) {
        models.put(1, "RickoFly");
        models.put(2, "Varenick");
        models.put(3, "Justice");
        models.put(4, "DoggyCar");
        models.put(5, "SnoppModile");
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

    public SuperCar getSuperCar() {
        return new SuperCar(models.get(randomCount()),color.get(randomCount()), (randomCount()*60), machineSeries.get(randomCount()),
                randomCount()*1500, randomCount()>3, randomCount()<=3);
    }

    private int randomCount() {
        return (int) (1 + Math.random() * 5);
    }
}
