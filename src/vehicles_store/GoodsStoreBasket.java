package vehicles_store;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class GoodsStoreBasket {
    private Map<Vehicle, Integer> basket = new LinkedHashMap<>();
    private Map<String, Vehicle> keys = new LinkedHashMap<>();
    private PrinterOfStore printer = new PrinterOfStore();

    public Map<Vehicle, Integer> getBasket() {
        return basket;
    }

    public Vehicle addVehicle(VehicleStore vehicleStore, String car) {
        if (vehicleStore.containsVehicle(car) && basket.containsKey(vehicleStore.getVehicle(car)) && basket.get(vehicleStore.getVehicle(car)) > 0) {
            int num = basket.get(vehicleStore.getVehicle(car));
            basket.put(vehicleStore.getVehicle(car), ++num);
            printer.addElementIsTrue();
            return vehicleStore.getVehicle(car);
            //add(vehicleStore.getVehicle(car));

        } else if (!basket.containsKey(vehicleStore) && vehicleStore.containsVehicle(car)) {
            basket.put(vehicleStore.getVehicle(car), 1);
            keys.put(car, vehicleStore.getVehicle(car));
            printer.addElementIsTrue();
            return vehicleStore.getVehicle(car);

            //add(vehicleStore.getVehicle(car));

        } else if (!vehicleStore.containsVehicle(car)) {
            printer.addElementIsFalse();
            return null;
        }
        return null;
    }

    public Vehicle getElementOfBasket(String key) {
        return keys.get(key);
    }

    public void removeVehicle(GoodsStoreBasket goodsStoreBasket, String car) {
        Vehicle carToRemove = goodsStoreBasket.getElementOfBasket(car);
        if (car.equals("0")) System.out.println("Вы вернулись в главное меню.");
        else if (!this.basket.containsKey(carToRemove)) {
            System.out.println("Не верно выбранный товар.\n" +
                    "Для удаления из корзины введите - car");
        } else if (this.basket.get(carToRemove) != 0 && this.basket.get(carToRemove) > 1) {
            this.basket.put(carToRemove, this.basket.get(carToRemove) - 1);
            System.out.println("Одна единица товара успешно удалена.\n" + "");
            //printer.menu();
        } else {
            this.basket.remove(carToRemove);
            System.out.println("Товар успешно удалён.\n" + "");
            //printer.menu();
        }
    }

    public void buyBasketContents() {
        int priceSum = 0;
        if (this.basket.isEmpty()) {
            printer.buyResult(priceSum);
        } else {
            for (Map.Entry<Vehicle, Integer> entry : this.basket.entrySet()) {
                Vehicle key = entry.getKey();
                priceSum += key.getPrice();
            }
            printer.buyResult(priceSum);
        }
    }

    public void printBasketList() {
        printer.basketList(this.basket);
    }

    public void printBeforeRemove() {
        printer.beforeRemove(this.basket, this.keys);

    }

    public void printBasketListBeforeCopy() {
        printer.beforeCopy(this.basket);
    }


}
