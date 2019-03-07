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

    public void basketList(Map<Vehicle, Integer> basket) {
        if (basket.isEmpty()) {
            System.out.println("Корзина пуста.");
        } else {
            for (Map.Entry<Vehicle, Integer> entry : basket.entrySet()) {
                Vehicle key = entry.getKey();
                Integer value = entry.getValue();
                System.out.println("Автомобиль \"" + key + "$, в корзине " + value + "\" экземпляр(ов/а).");
            }
            System.out.println("Для покупки товаров из корзины введите - buy + enter\n" +
                    "Для удаления из корзины введите - car + enter\n" +
                    "Для просмотра информации о 5 последних добавленных таварах введите last + enter\n" +
                    "Для возврата в меню магазина введите menu + enter");
        }
    }

    public void beforeRemove(Map<Vehicle, Integer> basket, Map<String, Vehicle> keys) {
        System.out.println("Выберете товар для удаления.\n" +
                "Для возврата в меню нажмите 0 + еnter");
        for (Map.Entry<Vehicle, Integer> entry : basket.entrySet()) {
            Vehicle key = entry.getKey();
            Integer value = entry.getValue();
            String carToString = "";
            for (Map.Entry<String, Vehicle> entryPair : keys.entrySet()) {
                String innerKey = entryPair.getKey();
                Vehicle innerValue = entryPair.getValue();
                if (key.equals(innerValue)) {
                    carToString = innerKey;
                }
            }
            System.out.println("Автомобиль \"" + key + "$ в наличии " + value + "\" экземпляр(ов/а). " + "Для удаления введите - " + carToString);
        }
    }

    public void buyResult(int priceSum) {
        System.out.println("Заказ оформленю. Сумма заказа " + priceSum + "\n" +
                "Если вы хотите покинуть магазин введите -1 + enter\n" +
                "Для возврата в меню магазина введите menu + enter");
    }
}
