package text_reader.file_search.file_filter_config;

import text_reader.file_search.FilteredFileList;
import text_reader.file_search.file_filter_config.ConfigFilter.AddConfig;

import java.io.File;

public class Filter extends BaseFilter {
    private final AddConfig addConfig;
    private final File[] filesInCatalog;
    private final FilteredFileList filteredFileList;

    public Filter(BaseFilter next, AddConfig addConfig, File[] filesInCatalog, FilteredFileList filteredFileList) {
        super(next);
        this.addConfig = addConfig;
        this.filesInCatalog = filesInCatalog;
        this.filteredFileList = filteredFileList;
    }

    @Override
    protected boolean execute() {
        showConfig();
        for (File file: filesInCatalog) {
            searchByName(file);
        }
        printResult();
        return true;
    }

    private boolean searchByName(File file) {

        return searchByExtension(file);

    }

    private boolean searchByExtension(File file) {
        return searchBySize(file);

    }

    private boolean searchBySize(File file) {
       return searchByDate(file);

    }

    private boolean searchByDate(File file) {
        return true;
    }

    private void printResult(){

    }

    private void showConfig() {
        System.out.println("Поиск файла по заданным критериям.");
        if (addConfig.getName() != null) System.out.println("Имя файла: " + addConfig.getName());
        if (addConfig.getType() != null) System.out.println("Разрешение файла: " + addConfig.getType());
        if (addConfig.getFromSize() > 0 && addConfig.getFromSize() <= addConfig.getToSize())
            System.out.println("Размер от - " + addConfig.getFromSize() + ", до - " + addConfig.getToSize());
        if (addConfig.getFromDate() > 0 && addConfig.getFromDate() <= addConfig.getToDate())
            System.out.println("Дата последнего изменения от - " + addConfig.getFromDate() + ", до - " + addConfig.getToDate());
    }

    @Override
    protected void printCommandGoal() {
        System.out.println("> Начать поиск ? (0/1)");
    }
}
