package text_reader.file_search.file_filter_config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class BaseFilterConfig implements FilterMaster {
    private final BaseFilterConfig next;
    private final String commandYes = "1";
    private final String commandNo = "0";


    protected BaseFilterConfig(BaseFilterConfig next) {
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

    protected abstract boolean execute();

    protected abstract void printCommandGoal();

}

