package vehicles_store.PurchaseOrder.commands.store_admin_config.add_random;

import vehicles_store.*;
import vehicles_store.PurchaseOrder.commands.store_admin_config.AddItemToStoreStrategies;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AddRandomVehicle implements AddItemToStoreStrategies {
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private VehicleStore vehicleStore;

    public AddRandomVehicle(VehicleStore vehicleStore) {
        this.vehicleStore = vehicleStore;
    }


    @Override
    public void addNewItem() {
        int randome = (int) (Math.random() * 4);
        Vehicle vehicle = choiceVehicle(randome);
        int randomeCount = 1+ (int) (Math.random() * 10);
        vehicleStore.addNewVehicle(vehicle, randomeCount);
    }

    public Vehicle choiceVehicle(int randome){
        if (randome == 1) return createCar();
        if (randome == 2) return createSuperCar();
        else return createPlane();
    }

    private Car createCar(){
        RandomCar randomeCar = new RandomCar();
        return randomeCar.getCar();
    }

    private SuperCar createSuperCar(){
        RandomSuperCar randomeSuperCar = new RandomSuperCar();
        return randomeSuperCar.getSuperCar();
    }

    private Plane createPlane(){
        RandomPlane randomePlane = new RandomPlane();
        return randomePlane.getPlane();
    }

}
