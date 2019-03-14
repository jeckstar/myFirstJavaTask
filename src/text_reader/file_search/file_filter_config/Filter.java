package text_reader.file_search.file_filter_config;

import text_reader.file_search.FilteredFileList;
import text_reader.file_search.file_filter_config.ConfigFilter.AddConfig;

import java.io.File;
import java.util.Date;

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
        for (File file : filesInCatalog) {
            searchByName(file);
        }
        printResult();
        return true;
    }

    private boolean searchByName(File file) {
        String fileName = addConfig.getName();
        if (file.getName().toLowerCase().contains(fileName.toLowerCase())) {
            if (addConfig.getType() != null) return searchByExtension(file);
            else if (addConfig.getFromSize() != 0 && addConfig.getToSize() != 0) return searchBySize(file);
            else if (addConfig.getFromDate() != null && addConfig.getToDate() != null) return searchByDate(file);
            else {
                filteredFileList.addFile(file);
                return true;
            }
        } else return false;

    }

    private boolean searchByExtension(File file) {
        String fileType = addConfig.getType();
        if (file.getName().toLowerCase().contains(fileType.toLowerCase())) {
            if (addConfig.getFromSize() != 0 && addConfig.getToSize() != 0) return searchBySize(file);
            else if (addConfig.getFromDate() != null && addConfig.getToDate() != null) return searchByDate(file);
            else {
                filteredFileList.addFile(file);
                return true;
            }
        } else return false;
    }

    private boolean searchBySize(File file) {
        long fileFromSize = addConfig.getFromSize();
        long fileToSize = addConfig.getToSize();
        if (file.length() > fileFromSize && file.length() < fileToSize) {
            if (addConfig.getFromDate() != null && addConfig.getToDate() != null) return searchByDate(file);
            filteredFileList.addFile(file);
            return true;
        } else return false;
    }

    private boolean searchByDate(File file) {
        Date fileFromDate = addConfig.getFromDate();
        Date fileToDate = addConfig.getToDate();
        Date dateOfLastModInThisFile = new Date(file.lastModified());
        if (dateOfLastModInThisFile.compareTo(fileFromDate) > -1 && dateOfLastModInThisFile.compareTo(fileToDate) < 1) {
            filteredFileList.addFile(file);
            return true;
        } else return false;
    }

    private void printResult() {
        filteredFileList.showResult();
    }

    private void showConfig() {
        System.out.println("Поиск файла по заданным критериям.");
        if (addConfig.getName() != null) System.out.println("Имя файла: " + addConfig.getName());
        if (addConfig.getType() != null) System.out.println("Разрешение файла: " + addConfig.getType());
        if (addConfig.getFromSize() >= 0 && addConfig.getFromSize() < addConfig.getToSize())
            System.out.println("Размер от - " + addConfig.getFromSize() / 1024 + " килобайт, до - " + addConfig.getToSize() / 1024 + " килобайт.");
        if (addConfig.getFromDate() != null && addConfig.getFromDate() != null)
        System.out.println("Дата последнего изменения от - " + addConfig.getFromDate() + ", до - " + addConfig.getToDate());
    }

    @Override
    protected void printCommandGoal() {
        System.out.println("> Начать поиск ? (0/1)");
    }
}
