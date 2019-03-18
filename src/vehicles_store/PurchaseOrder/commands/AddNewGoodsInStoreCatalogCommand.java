package vehicles_store.PurchaseOrder.commands;

import vehicles_store.VehicleStore;

import java.io.BufferedReader;
import java.io.IOException;

public class AddNewGoodsInStoreCatalogCommand extends BaseChain {
    private VehicleStore vehicleStore;
    private final BufferedReader reader;
    private final String password = "12345";


    public AddNewGoodsInStoreCatalogCommand(BaseChain next, String code, VehicleStore vehicleStore, BufferedReader reader) {
        super(next, code);
        this.vehicleStore = vehicleStore;
        this.reader = reader;
    }

    @Override
    protected boolean execute() {
        String pasToCheck = getPass();
        if(checkPassword(pasToCheck)) {
            String model = getModel();
            String color = getColor();
            int maxSpeed = getMaxSpeed();
            String machineSeries = getMachineSeries();
            int prise = getPrise();
            int countOfItem = getCountOfItem();
            vehicleStore.addNewItem(model, color, maxSpeed, machineSeries, prise, countOfItem);
        }
        else System.out.println("Пароль не верный. Доступ к добавлению в каталог не получен!");
        return true;
    }

    private boolean checkPassword(String pasToCheck){
        return pasToCheck.equals(password);
    }

    private String getPass(){
        String pasToCheck;
        System.out.println("Введите пароль администратора.");
        try {
            pasToCheck = reader.readLine();
        } catch (IOException e) {
            pasToCheck = getMachineSeries();
        }
        return pasToCheck;
    }

    private int getCountOfItem() {
        System.out.println("модель максимальную скорость (eng):");
        int countOfItem = 0;
        try {
            countOfItem = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            repMessage();
            countOfItem = getCountOfItem();
        }
        if (countOfItem <= 0){
            System.out.println("повторите ввод!\n" +
                    "вы ввели число меньше 0");
            countOfItem = getCountOfItem();
        }
        return countOfItem;
    }

    private int getPrise() {
        System.out.println("модель максимальную скорость (eng):");
        int prise = 0;
        try {
            prise = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            repMessage();
            prise = getPrise();
        }
        if (prise <= 0){
            System.out.println("повторите ввод!\n" +
                    "вы ввели число меньше 0");
            prise = getPrise();
        }
        return prise;
    }

    private String getMachineSeries() {
        System.out.println("модель серию (eng):");
        String machineSeries;
        try {
            machineSeries = reader.readLine();
        } catch (IOException e) {
            repMessage();
            machineSeries = getMachineSeries();
        }
        if (machineSeries.isEmpty() || machineSeries.length()>2){
            repMessage();
            machineSeries = getMachineSeries();
        }
        return machineSeries;
    }

    private int getMaxSpeed() {
        System.out.println("модель максимальную скорость (eng):");
        int maxSpeed = 0;
        try {
            maxSpeed = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            repMessage();
            maxSpeed = getMaxSpeed();
        }
        if (maxSpeed <= 0){
            System.out.println("повторите ввод!\n" +
                    "вы ввели число меньше 0");
            maxSpeed = getMaxSpeed();
        }
        return maxSpeed;
    }

    private String getColor(){
        System.out.println("модель цвет (eng):");
        String color;
        try {
            color = reader.readLine();
        } catch (IOException e) {
            repMessage();
            color = getModel();
        }
        if (color.isEmpty()){
            repMessage();
            color = getModel();
        }
        return color;
    }

    private String getModel(){
        System.out.println("модель авто (eng):");
        String model;
        try {
            model = reader.readLine();
        } catch (IOException e) {
            repMessage();
            model = getModel();
        }
        if (model.isEmpty()){
            repMessage();
            model = getModel();
        }
        return model;
    }

    private void repMessage(){
        System.out.println("повторите ввод!");
    }

    @Override
    protected void printCommandGoal() {
        System.out.println("Введите newGoods для добавления новых товаров в каталог. ");
    }
}
