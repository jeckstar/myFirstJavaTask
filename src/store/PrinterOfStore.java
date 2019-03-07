package store;

import java.util.Map;

public class PrinterOfStore {

    public PrinterOfStore() {
    }

    public void addElementIsTrue() {
        System.out.println("Товар успешно добавлен в корзину.\n" +
                "Для продолжения добавления товара в корзину введите - add + enter\n" +
                "Для продолжения просмотра товара в наличии введите 1 + enter\n" +
                "Для просмотра корзины введите 2 + enter");
    }

    public void addElementIsFalse() {
        System.out.println("Не верно введено название товара. \n" +
                "Для добавления в корзину введите - add + enter\n" +
                "Для продолжения просмотра товара в наличии введите 1 + enter\n" +
                "Для просмотра корзины введите 2 + enter");
    }

    public void StoreList(Map<Vehicle, Integer> vehicleAvailability) {
        for (Map.Entry<Vehicle, Integer> entry : vehicleAvailability.entrySet()) {
            Vehicle key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("Автомобиль \"" + key + "$, в наличии " + value + "\" экземпляр(ов/а).");
        }
        System.out.println("Для добавления в корзину введите - add + enter");
    }

    public void menu() {
        System.out.println("Введите 1 + enter для просмотра товара в наличии\n" +
                "Введите -1 + enter завершение визита магазина\n" +
                "Введите 2 + enter для просмотра корзины\n");
    }

    public void BasketList(Map<Vehicle, Integer> basket){
        if (basket.isEmpty()) {
            System.out.println("Корзина пуста.");
        } else {
            for (Map.Entry<Vehicle, Integer> entry : basket.entrySet()) {
                Vehicle key = entry.getKey();
                Integer value = entry.getValue();
                System.out.println("Автомобиль \"" + key + "$, в корзине " + value + "\" экземпляр(ов/а).");
            }
            System.out.println("Для удаления из корзины введите - car + enter");
        }
    }
}
