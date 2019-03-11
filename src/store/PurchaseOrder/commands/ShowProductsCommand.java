package store.PurchaseOrder.commands;

import store.VehicleStore;

public class ShowProductsCommand extends BaseChain {

    private final VehicleStore vehicleStore;

    protected ShowProductsCommand(BaseChain next, String code, VehicleStore vehicleStore) {
        super(next, code);
        this.vehicleStore = vehicleStore;
    }

    @Override
    protected void execute() {
        vehicleStore.printStoreList();
    }

    @Override
    protected void printCommandGoal() {
        System.out.println("Введите 1 + enter для просмотра товара в наличии.");
    }
}
