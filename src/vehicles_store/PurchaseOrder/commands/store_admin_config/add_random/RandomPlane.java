package vehicles_store.PurchaseOrder.commands.store_admin_config.add_random;

import vehicles_store.Plane;

import java.util.HashMap;
import java.util.Map;


public class RandomPlane {
    private Map<Integer, String> models = new HashMap<>();
    private Map<Integer, String> color = new HashMap<>();

    public RandomPlane() {
        models.put(1, "S-wing");
        models.put(2, "Aurora");
        models.put(3, "Killer");
        models.put(4, "Boeing 666");
        models.put(5, "SU 77");
        color.put(1, "Blue");
        color.put(2, "White");
        color.put(3, "Grey");
        color.put(4, "Blue");
        color.put(5, "Black");
    }

    public Plane getPlane() {
        return new Plane(models.get(randomCount()),color.get(randomCount()), (randomCount()*60), randomCount()*300, randomCount()*1500);
    }

    private int randomCount() {
        return (int) (1 + Math.random() * 5);
    }

}
