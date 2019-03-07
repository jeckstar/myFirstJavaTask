package store;

import java.util.LinkedHashMap;
import java.util.Map;

public class GoodsStoreBasket {
    private Map<Vehicle, Integer> basket = new LinkedHashMap<>();
    private Map<String, Vehicle> keys = new LinkedHashMap<>();
    private PrinterOfStore printer = new PrinterOfStore();


    public GoodsStoreBasket() {
        this.basket = basket;
    }

    public void addVehicle(VehicleStore vehicleStore, String car) {
        if (vehicleStore.containsVehicle(car) && basket.containsKey(vehicleStore.getVehicle(car)) && basket.get(vehicleStore.getVehicle(car)) > 0) {
            int num = basket.get(vehicleStore.getVehicle(car));
            basket.put(vehicleStore.getVehicle(car), ++num);
            printer.addElementIsTrue();
        } else if (!basket.containsKey(vehicleStore) && vehicleStore.containsVehicle(car)) {
            basket.put(vehicleStore.getVehicle(car), 1);
            keys.put(car, vehicleStore.getVehicle(car));
            printer.addElementIsTrue();
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

    }

    public void lookLastFiveGoods() {

    }

    public void printBasketList() {
        printer.BasketList(this.basket);
    }

    public void printBeforeRemove() {
        System.out.println("Выберете товар для удаления.\n" +
                "Для возврата в меню нажмите 0 + еnter");
        for (Map.Entry<Vehicle, Integer> entry : this.basket.entrySet()) {
            Vehicle key = entry.getKey();
            Integer value = entry.getValue();
            String carToString = this.carToStringByKey(key);
            System.out.println("Автомобиль \"" + key + "$, в наличии " + value + "\" экземпляр(ов/а). " + "Для удаления введите - " + carToString);
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
