package text_reader.file_search;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FilteredFileList {
    private final List<File> filteredList = new ArrayList<>();

    public boolean addFile(File file) {
        return filteredList.add(file);
    }

    public void showResult() {
        if (!filteredList.isEmpty()) {
            for (File file : filteredList) {
                System.out.println(file);
            }
        } else System.out.println("Ничего не найдено :( \n" + "Сорямба.");
    }
}
