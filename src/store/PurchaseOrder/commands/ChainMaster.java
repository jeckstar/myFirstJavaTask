package store.PurchaseOrder.commands;

public interface ChainMaster {

    boolean handleCommand(String commandCode);

    void printCommandsSequence();

}
