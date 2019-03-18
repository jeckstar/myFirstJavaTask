package vehicles_store.PurchaseOrder.commands;

import vehicles_store.PurchaseOrder.commands.store_admin_config.AddItemToStore;
import vehicles_store.PurchaseOrder.commands.store_admin_config.AddNewCarToStore;
import vehicles_store.PurchaseOrder.commands.store_admin_config.AddNewPlaneToStore;
import vehicles_store.PurchaseOrder.commands.store_admin_config.AddNewSuperCarToStore;
import vehicles_store.VehicleStore;

import java.io.BufferedReader;
import java.io.IOException;

public class AddNewGoodsInStoreCatalogCommand extends BaseChain {
    private VehicleStore vehicleStore;
    private final BufferedReader reader;
    private final String password = "12345";
    private AddItemToStore addItemToStore;

    public AddNewGoodsInStoreCatalogCommand(BaseChain next, String code, VehicleStore vehicleStore, BufferedReader reader) {
        super(next, code);
        this.vehicleStore = vehicleStore;
        this.reader = reader;
    }

    @Override
    protected boolean execute() {
        String pasToCheck = getPass();
        if(checkPassword(pasToCheck)) {
            try {
                addItemToStore = getChoiсe();
            } catch (IOException e) {
                e.printStackTrace();
            }
            addItemToStore.addNewItem();
        }
        else System.out.println("Пароль не верный. Доступ к добавлению в каталог не получен!");
        return true;
    }

    private AddItemToStore getChoiсe() throws IOException {
        addInfo();
        String choice = reader.readLine();
        if (choice.equals("1")){
            return new AddNewCarToStore(vehicleStore);
        }
        else if (choice.equals("2")){
            return new AddNewSuperCarToStore(vehicleStore);
        }
        else if(choice.equals("3")){
            return new AddNewPlaneToStore(vehicleStore);
        }
        else {
            System.out.println("Вы ввели неверную категорию товара. Повторите ввод.");
            return getChoiсe();
        }
    }

    private void addInfo(){
        System.out.println("Для добавления выберите категорию товара\n"+
                "1 - автомобиль\n"+
                "2 - суперкар\n"+
                "3 - самолет\n");
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

    private boolean checkPassword(String pasToCheck){
        return pasToCheck.equals(password);
    }

    @Override
    protected void printCommandGoal() {
        System.out.println("Введите newGoods для добавления новых товаров в каталог. ");
    }
}
