package vehicles_store.PurchaseOrder.commands;

import java.io.IOException;

public abstract class BaseChain implements ChainMaster {

    public static final BaseChain NO_OP_CHAIN = new BaseChain(null, null) {
        @Override
        protected boolean execute() {
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
    public final boolean handleCommand(String commandCode) {
        if (code.equals(commandCode)) {
            return execute();
        } else if (this.next == NO_OP_CHAIN) {
            throw new NoSuchCommandException();
        } else {
            return next.handleCommand(commandCode);
        }
    }

    protected abstract boolean execute() ;

    @Override
    public void printCommandsSequence() {
        this.printCommandGoal();
        if (this.next != NO_OP_CHAIN) {
            next.printCommandsSequence();
        }
    }

    protected abstract void printCommandGoal();

}
