package text_reader.file_search.file_filter_config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class BaseFilter implements FilterMaster {
    private final BaseFilter next;
    private final String commandYes = "1";
    private final String commandNo = "0";

    public static final BaseFilter NO_OP_CHAIN = new BaseFilter(null) {
        @Override
        protected boolean execute() {
            throw new UnsupportedOperationException();
        }

        @Override
        protected void printCommandGoal() {
            throw new UnsupportedOperationException();
        }

    };

        protected BaseFilter(BaseFilter next) {
        this.next = next;
    }

    @Override
    public final boolean handleCommand() {
        this.printCommandGoal();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String code = null;
        try {
            code = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (code.equals(commandYes)) {
            execute();
            next.handleCommand();
            return true;
        } else if (code.equals(commandNo)) {
            return next.handleCommand();
        } else return true;
    }

    protected abstract boolean execute();

    protected abstract void printCommandGoal();

}

