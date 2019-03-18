package vehicles_store;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class VehicleStore implements Serializable {
    private Map<Vehicle, Integer> vehicleAvailability = new LinkedHashMap<>();
    private Map<String, Vehicle> keys = new LinkedHashMap<>();
    private PrinterOfStore printer = new PrinterOfStore();
    private int countOfItemInStore = 8;


    public VehicleStore() {
        final Vehicle car1 = new Car("BMW x5", "Blue", 240, "A", 35000);
        final Vehicle car2 = new Car("BMW x3", "White", 210, "A", 34000);
        final Vehicle car3 = new Car("Mazda 6", "Black", 250, "A", 32500);
        final Vehicle car4 = new Car("Mazda 6", "White", 250, "A", 32500);
        final Vehicle car5 = new Car("ZAZ 2101", "Black", 180, "F", 3000);
        final Vehicle car6 = new Car("Dewoo Sens", "Silver", 190, "F+", 5000);
        final Vehicle car7 = new Car("Nissan Juke", "Green", 200, "B", 20000);
        final Vehicle car8 = new Car("Nissan Juke", "Black", 250, "B", 20000);

        vehicleAvailability.put(car1, 5);
        vehicleAvailability.put(car2, 5);
        vehicleAvailability.put(car3, 5);
        vehicleAvailability.put(car4, 5);
        vehicleAvailability.put(car5, 5);
        vehicleAvailability.put(car6, 5);
        vehicleAvailability.put(car7, 5);
        vehicleAvailability.put(car8, 5);

        keys.put("car1", car1);
        keys.put("car2", car2);
        keys.put("car3", car3);
        keys.put("car4", car4);
        keys.put("car5", car5);
        keys.put("car6", car6);
        keys.put("car7", car7);
        keys.put("car8", car8);

    }
    public boolean addNewVehicle(Vehicle vehicle, int countOfItem){
        countOfItemInStore++;
        keys.put("car"+countOfItemInStore, vehicle);
        vehicleAvailability.put(keys.get("car"+countOfItemInStore), countOfItem);
        return true;
    }


    public boolean containsVehicle(String car) {
        return keys.containsKey(car);
    }

    public Vehicle getVehicle(String key) {
        return keys.get(key);
    }

    public void printStoreList() {
        printer.storeList(this.vehicleAvailability);
    }

    public void listOfItem() {
        for (Map.Entry<Vehicle, Integer> entry : this.vehicleAvailability.entrySet()) {
            Vehicle key = entry.getKey();
            Integer value = entry.getValue();
            String carToString = this.carToStringByKey(key);
            System.out.println("Автомобиль \"" + key + " в наличии " + value + "\" экземпляр(ов/а). " + "Для для добавления в корзину введите - " + carToString);
        }
    }

    private String carToStringByKey(Vehicle key) {
        String vehicleName = "";
        for (Map.Entry<String, Vehicle> entryPair : this.keys.entrySet()) {
            String innerKey = entryPair.getKey();
            Vehicle innerValue = entryPair.getValue();
            if (key.equals(innerValue)) {
                vehicleName = innerKey;
            }
        }
        return vehicleName;
    }
}

