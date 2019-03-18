package vehicles_store.PurchaseOrder.commands.store_admin_config.add_from_console;

import vehicles_store.Car;
import vehicles_store.PurchaseOrder.commands.store_admin_config.AddItemToStoreStrategies;
import vehicles_store.Vehicle;
import vehicles_store.VehicleStore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddNewCarToStore implements AddItemToStoreStrategies {
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private VehicleStore vehicleStore;

    public AddNewCarToStore(VehicleStore vehicleStore) {
        this.vehicleStore = vehicleStore;
    }

    public void addNewItem() {
        String model = getModel();
        String color = getColor();
        int maxSpeed = getMaxSpeed();
        String machineSeries = getMachineSeries();
        int prise = getPrise();
        int countOfItem = getCountOfItem();
        Vehicle vehicle = new Car(model, color, maxSpeed, machineSeries, prise);
        vehicleStore.addNewVehicle(vehicle, countOfItem);
    }

    private int getCountOfItem() {
        System.out.println("введите количество авто " +
                "(ангар принимает до 10 новых авто за раз):");
        int countOfItem;
        try {
            countOfItem = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            repMessage();
            countOfItem = getCountOfItem();
        }
        if (countOfItem <= 0 || countOfItem > 10) {
            System.out.println("повторите ввод!\n" +
                    "вы ввели число меньше 0, либо больше 10");
            countOfItem = getCountOfItem();
        }
        return countOfItem;
    }

    private int getPrise() {
        System.out.println("введите стоимость авто:");
        int prise = 0;
        try {
            prise = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            repMessage();
            prise = getPrise();
        }
        if (prise <= 0) {
            System.out.println("повторите ввод!\n" +
                    "вы ввели число меньше 0");
            prise = getPrise();
        }
        return prise;
    }

    private String getMachineSeries() {
        System.out.println("введите серию (eng):");
        String machineSeries;
        try {
            machineSeries = reader.readLine();
        } catch (IOException e) {
            repMessage();
            machineSeries = getMachineSeries();
        }
        if (machineSeries.isEmpty() || machineSeries.length() > 2) {
            repMessage();
            machineSeries = getMachineSeries();
        }
        return machineSeries;
    }

    private int getMaxSpeed() {
        System.out.println("введите максимальную скорость (eng):");
        int maxSpeed = 0;
        try {
            maxSpeed = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            repMessage();
            maxSpeed = getMaxSpeed();
        }
        if (maxSpeed <= 0) {
            System.out.println("повторите ввод!\n" +
                    "вы ввели число меньше 0");
            maxSpeed = getMaxSpeed();
        }
        return maxSpeed;
    }

    private String getColor() {
        System.out.println("введите цвет (eng):");
        String color;
        try {
            color = reader.readLine();
        } catch (IOException e) {
            repMessage();
            color = getModel();
        }
        if (color.isEmpty()) {
            repMessage();
            color = getModel();
        }
        return color;
    }

    private String getModel() {
        System.out.println("введите модель авто (eng):");
        String model;
        try {
            model = reader.readLine();
        } catch (IOException e) {
            repMessage();
            model = getModel();
        }
        if (model.isEmpty()) {
            repMessage();
            model = getModel();
        }
        return model;
    }

    private void repMessage() {
        System.out.println("повторите ввод!");
    }
}