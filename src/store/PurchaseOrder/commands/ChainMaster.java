package store.PurchaseOrder.commands;

public interface ChainMaster {

    void handleCommand(String commandCode);

    void printCommandsSequence();

}
