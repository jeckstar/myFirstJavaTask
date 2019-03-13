package text_reader.file_search.file_filter_config.ConfigFilter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AllConfig {
    private String name = null;
    private String type = null;
    private long fromSize = 0;
    private long toSize = 0;
    private long fromDate = 0;
    private long toDate = 0;
    private final String commandYes = "1";
    private final String commandNo = "0";


    public void AllConfig() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String code = null;
        try {
            code = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (code.equals(commandYes)) {


        } else if (code.equals(commandNo)) {

        } else ;
    }

    public String getName() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Введите имя файла:");
            String line = reader.readLine();
            System.out.println(line);
            name = line;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return name;
    }
}
