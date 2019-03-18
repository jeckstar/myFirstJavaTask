package vehicles_store.PurchaseOrder.commands;

import vehicles_store.PurchaseOrder.commands.store_admin_config.AddItemToStoreStrategies;
import vehicles_store.PurchaseOrder.commands.store_admin_config.add_from_console.AddNewCarToStore;
import vehicles_store.PurchaseOrder.commands.store_admin_config.add_from_console.AddNewPlaneToStore;
import vehicles_store.PurchaseOrder.commands.store_admin_config.add_from_console.AddNewSuperCarToStore;
import vehicles_store.PurchaseOrder.commands.store_admin_config.add_random.AddRandomVehicle;
import vehicles_store.VehicleStore;

import java.io.BufferedReader;
import java.io.IOException;

public class AddNewGoodsInStoreCatalogCommand extends BaseChain {
    private VehicleStore vehicleStore;
    private final BufferedReader reader;
    private final String password = "12345";
    private AddItemToStoreStrategies addItemToStore;

    public AddNewGoodsInStoreCatalogCommand(BaseChain next, String code, VehicleStore vehicleStore, BufferedReader reader) {
        super(next, code);
        this.vehicleStore = vehicleStore;
        this.reader = reader;
    }

    @Override
    protected boolean execute() {
        String pasToCheck = getPass();
        if (checkPassword(pasToCheck)) {
            addItemToStore = strategies();
            addItemToStore.addNewItem();
            System.out.println("Операция преведена успешно.");
        } else System.out.println("Пароль не верный. Доступ к добавлению в каталог не получен!");
        return true;
    }

    private void addInfo() {
        System.out.println("Для добавления выберите категорию товара\n" +
                "1 - автомобиль\n" +
                "2 - суперкар\n" +
                "3 - самолет\n");
    }

    private AddItemToStoreStrategies strategies() {
        System.out.println("Добавить товар вручную - 1 ?\n" +
        "Добавить товар случайно - 2 ?");
        String strategiesVariant = null;
        try {
            strategiesVariant = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (strategiesVariant.equals("1")) {
            try {
                return addItemToStore = getChoiсe();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (strategiesVariant.equals("2")) {
            return addItemToStore = new AddRandomVehicle(vehicleStore);
        } else System.out.println("Неккорректный выбор стратегии");
        return strategies();
    }

    private AddItemToStoreStrategies getChoiсe() throws IOException {
        addInfo();
        String choice = reader.readLine();
        if (choice.equals("1")) {
            return new AddNewCarToStore(vehicleStore);
        } else if (choice.equals("2")) {
            return new AddNewSuperCarToStore(vehicleStore);
        } else if (choice.equals("3")) {
            return new AddNewPlaneToStore(vehicleStore);
        } else {
            System.out.println("Вы ввели неверную категорию товара. Повторите ввод.");
            return getChoiсe();
        }
    }

    private String getPass() {
        String pasToCheck = null;
        System.out.println("Введите пароль администратора.");
        try {
            pasToCheck = reader.readLine();
        } catch (IOException e) {
        }
        return pasToCheck;
    }

    private boolean checkPassword(String pasToCheck) {
        return pasToCheck.equals(password);
    }

    @Override
    protected void printCommandGoal() {
        System.out.println("Введите newGoods для добавления новых товаров в каталог. ");
    }
}
