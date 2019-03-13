package text_reader.file_search.file_filter_config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class BaseFilter implements FilterMaster {
    private final BaseFilter next;
    private final String commandYes = "1";
    private final String commandNo = "0";


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
            return next.handleCommand();
        } else if (code.equals(commandNo)) {
            return next.handleCommand();
        } else return false;
    }

    protected abstract void execute();

    protected abstract void printCommandGoal();

}

