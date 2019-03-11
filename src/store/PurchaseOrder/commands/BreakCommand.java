package store.PurchaseOrder.commands;

public class BreakCommand extends BaseChain {

    public BreakCommand(BaseChain next, String code) {
        super(next, code);
    }

    @Override
    protected void execute() {
        
    }

    @Override
    protected void printCommandGoal() {
        System.out.println("Введите exit + enter для выхода из магазина.");
    }
}
