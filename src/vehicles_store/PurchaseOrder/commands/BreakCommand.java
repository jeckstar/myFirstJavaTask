package vehicles_store.PurchaseOrder.commands;

public class BreakCommand extends BaseChain {

    public BreakCommand(BaseChain next, String code) {
        super(next, code);
    }

    @Override
    protected boolean execute() {
        System.out.println("До встречи!");
        return false;
    }

    @Override
    protected void printCommandGoal() {
        System.out.println("Введите exit + enter для выхода из магазина.");
    }
}
