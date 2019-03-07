package store;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class GoodsStoreBasket {
    private Map<Vehicle, Integer> basket = new LinkedHashMap<>();
    private Map<String, Vehicle> keys = new LinkedHashMap<>();
    private PrinterOfStore printer = new PrinterOfStore();
    private ArrayList<Vehicle> last5Add = new ArrayList<>();
    //private Vehicle[] last5Add = new Vehicle[5];
    private int count = 0;
    private int countNum = 0;


    public GoodsStoreBasket() {
        this.basket = basket;
    }

    public void addVehicle(VehicleStore vehicleStore, String car) {
        if (vehicleStore.containsVehicle(car) && basket.containsKey(vehicleStore.getVehicle(car)) && basket.get(vehicleStore.getVehicle(car)) > 0) {
            int num = basket.get(vehicleStore.getVehicle(car));
            basket.put(vehicleStore.getVehicle(car), ++num);
            printer.addElementIsTrue();

            lastFiveGoods(vehicleStore.getVehicle(car));

        } else if (!basket.containsKey(vehicleStore) && vehicleStore.containsVehicle(car)) {
            basket.put(vehicleStore.getVehicle(car), 1);
            keys.put(car, vehicleStore.getVehicle(car));
            printer.addElementIsTrue();

            lastFiveGoods(vehicleStore.getVehicle(car));

        } else if (!vehicleStore.containsVehicle(car)) {
            printer.addElementIsFalse();
        }
    }

    public Vehicle getElementOfBasket(String key) {
        return keys.get(key);
    }

    public void removeVehicle(GoodsStoreBasket goodsStoreBasket, String car) {
        Vehicle carToRemove = goodsStoreBasket.getElementOfBasket(car);
        if (!this.basket.containsKey(carToRemove)) {
            System.out.println("Не верно выбранный товар.\n" +
                    "Для удаления из корзины введите - car");
        } else if (this.basket.get(carToRemove) != 0 && this.basket.get(carToRemove) > 1) {
            this.basket.put(carToRemove, this.basket.get(carToRemove) - 1);
            System.out.println("Одна единица товара успешно удалена.");
        } else {
            this.basket.remove(carToRemove);
            System.out.println("Товар успешно удалён.");
        }
    }

    public void buyBasketContents() {
        int priceSum = 0;
        for (Map.Entry<Vehicle, Integer> entry : this.basket.entrySet()) {
            Vehicle key = entry.getKey();
            priceSum += key.getPrice();
        }
        printer.buyResult(priceSum);
    }

    public void lastFiveGoods(Vehicle vehicle) {
        if (count > 4) {
            if (countNum > 4) {
                count = 0;
                last5Add.set(count, vehicle);
            }
            last5Add.set(countNum, vehicle);
            countNum++;
        }
        else last5Add.add(vehicle);
        count++;
    }

    public void lookLastFiveGoods() {
        for (int i = 0; i < last5Add.size(); i++) {
            System.out.println(last5Add.get(i));
        }
    }

    public void printBasketList() {
        printer.basketList(this.basket);
    }

    public void printBeforeRemove() {
        printer.beforeRemove(this.basket, this.keys);

    }
}
