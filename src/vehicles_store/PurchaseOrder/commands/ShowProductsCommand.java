package vehicles_store.PurchaseOrder.commands;

import vehicles_store.VehicleStore;

public class ShowProductsCommand extends BaseChain {

    private final VehicleStore vehicleStore;

    public ShowProductsCommand(BaseChain next, String code, VehicleStore vehicleStore) {
        super(next, code);
        this.vehicleStore = vehicleStore;
    }

    @Override
    protected boolean execute() {
        vehicleStore.printStoreList();
        return true;
    }

    @Override
    protected void printCommandGoal() {
        System.out.println("Введите 1 + enter для просмотра товара в наличии.");
    }
}
