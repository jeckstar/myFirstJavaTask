package store.PurchaseOrder.commands;

public abstract class BaseChain implements ChainMaster {

    public static final BaseChain NO_OP_CHAIN = new BaseChain(null, null) {
        @Override
        protected void execute() {
            throw new UnsupportedOperationException();
        }

        @Override
        protected void printCommandGoal() {
            throw new UnsupportedOperationException();
        }

    };

    private final BaseChain next;
    private final String code;

    protected BaseChain(BaseChain next, String code) {
        this.next = next;
        this.code = code;
    }

    @Override
    public final void handleCommand(String commandCode) {
        if (code.equals(commandCode)) {
            execute();
        } else if (this.next == NO_OP_CHAIN) {
            throw new NoSuchCommandException();
        } else {
            next.handleCommand(commandCode);
        }
    }

    protected abstract void execute();

    @Override
    public void printCommandsSequence() {
        this.printCommandGoal();
        if (this.next != NO_OP_CHAIN) {
            next.printCommandsSequence();
        }
    }

    protected abstract void printCommandGoal();

}
