package text_reader.file_search;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FilteredFileList {
    private final List<File> filteredList = new ArrayList<>();

    public boolean addFile(File file) {
        return filteredList.add(file);
    }

    public void showResult() {
        if (!filteredList.isEmpty()) {
            for (File file : filteredList) {
                DateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
                Date date = new Date(file.lastModified());
                System.out.println(file + " дата последнего изменения " + s.format(date));
            }
        } else System.out.println("Ничего не найдено :( \n" + "Сорямба.");
    }
}
