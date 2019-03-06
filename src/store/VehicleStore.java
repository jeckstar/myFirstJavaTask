package store;

import java.util.LinkedHashMap;
import java.util.Map;

public class VehicleStore {
    private Map<Vehicle, Integer> vehicleAvailability = new LinkedHashMap<>();

    public VehicleStore() {
        final Vehicle car1 = new Car("BMW x5", "Blue", 240, "A", 5);
        final Vehicle car2 = new Car("BMW x3", "White", 210, "A", 5);
        final Vehicle car3 = new Car("Mazda 6", "Black", 250, "A", 4);
        final Vehicle car4 = new Car("Mazda 6", "White", 250, "A", 4);
        final Vehicle car5 = new Car("ZAZ 2101", "Black", 180, "F", 5);
        final Vehicle car6 = new Car("Dewoo Sens", "Silver", 190, "F+", 5);
        final Vehicle car7 = new Car("Nissan Juke", "Green", 200, "B", 5);
        final Vehicle car8 = new Car("Nissan Juke", "Black", 250, "B", 5);


        vehicleAvailability.put(car1, 2);
        vehicleAvailability.put(car2, 4);
        vehicleAvailability.put(car3, 2);
        vehicleAvailability.put(car4, 1);
        vehicleAvailability.put(car5, 4);
        vehicleAvailability.put(car6, 10);
        vehicleAvailability.put(car7, 2);
        vehicleAvailability.put(car8, 2);

    }

    public void printStoreList() {
        int numInlist = 1;
        for (Map.Entry<Vehicle, Integer> entry : this.vehicleAvailability.entrySet()) {
            Vehicle key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("Автомобиль" + key + " в наличии " + value + " экземпляр(ов/а). " + "Для выбора введите - " + "car" + Integer.toString(numInlist));
            numInlist++;
        }
    }
}
