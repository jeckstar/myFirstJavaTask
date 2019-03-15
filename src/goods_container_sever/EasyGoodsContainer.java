package goods_container_sever;

import vehicles_store.Car;
import vehicles_store.Vehicle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EasyGoodsContainer implements Serializable {
    private final List<Vehicle> vehicleAvailability = new ArrayList<Vehicle>();

    public EasyGoodsContainer() {
        final Vehicle car1 = new Car("BMW x5", "Blue", 240, "A", 35000);
        final Vehicle car2 = new Car("BMW x3", "White", 210, "A", 34000);
        final Vehicle car3 = new Car("Mazda 6", "Black", 250, "A", 32500);
        final Vehicle car4 = new Car("Mazda 6", "White", 250, "A", 32500);
        final Vehicle car5 = new Car("ZAZ 2101", "Black", 180, "F", 3000);
        final Vehicle car6 = new Car("Dewoo Sens", "Silver", 190, "F+", 5000);
        final Vehicle car7 = new Car("Nissan Juke", "Green", 200, "B", 20000);
        final Vehicle car8 = new Car("Nissan Juke", "Black", 250, "B", 20000);
        vehicleAvailability.add(car1);
        vehicleAvailability.add(car2);
        vehicleAvailability.add(car3);
        vehicleAvailability.add(car4);
        vehicleAvailability.add(car5);
        vehicleAvailability.add(car6);
        vehicleAvailability.add(car7);
        vehicleAvailability.add(car8);
    }

    @Override
    public String toString() {
        String rerurnToString = null;
        for (Vehicle vehicle : vehicleAvailability) {
            rerurnToString += vehicle.toString() + "\n";
        }
        return rerurnToString;
    }

}
