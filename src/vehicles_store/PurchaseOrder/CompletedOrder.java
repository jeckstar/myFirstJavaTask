package vehicles_store.PurchaseOrder;

import vehicles_store.Vehicle;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class CompletedOrder {

    private final DateOfOrder date;
    private final List<Vehicle> vehicles;

    public CompletedOrder(DateOfOrder date, List<Vehicle> vehicles) {
        this.date = date;
        this.vehicles = Collections.unmodifiableList(vehicles);
    }

    public CompletedOrder(Map.Entry<DateOfOrder, List<Vehicle>> entry) {
        this.date = entry.getKey();
        this.vehicles = Collections.unmodifiableList(entry.getValue());
    }

    public DateOfOrder getDate() {
        return date;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }
}
