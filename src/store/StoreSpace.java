package store;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;

public class StoreSpace {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        VehicleStore vehicleStore = new VehicleStore();
        GoodsStoreBasket storeBasket = new GoodsStoreBasket();
        System.out.println("Введите+enter 1 просморт товара в наличии\n" +
                "Введите+enter -1 завершение визита магазина\n");
        while (true) {
            int command = Integer.parseInt(reader.readLine());
            if (command == 1){
                vehicleStore.printStoreList();
            }
            if(command == -1) break;
        }
    }
}
