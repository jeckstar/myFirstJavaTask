package text_reader.file_search;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileCatalog {
    private String directoryName;
    private File catalog;
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static List<File> temporaryFileStorage = new ArrayList<File>();

    public FileCatalog() throws IOException {
        catalog = createFileCatalog();
    }

    public File getCatalog() {
        return catalog;
    }

    private File createFileCatalog() throws IOException {
        showRequirements();
        directoryName = reader.readLine();
        File directory = new File(directoryName);
        if (directory.isDirectory()) {
            //System.out.println("Каталог прошел проверку.");
            return directory;
        } else {
            System.out.println("Неверно введен каталог.");
            return createFileCatalog();
        }
    }

    private void showRequirements() {
        System.out.println("Введите каталог для поиска.");
    }

    public File[] getFileList() {
        File[] innerCatalog = catalog.listFiles();
        //innerCatalog = checkFilesAndReturnArray(innerCatalog);
        return checkFilesAndReturnArray(innerCatalog);
    }

    private static File[] checkFilesAndReturnArray(File[] files) {
       for (File file : files) {
           if (file.isDirectory()) {
                transformDirectory(file);
           } else if (file.isFile()) temporaryFileStorage.add(file);

        }
        File[] returnList = temporaryFileStorage.toArray(File[]::new);
        temporaryFileStorage.clear();
        return returnList;
    }

    private static void transformDirectory(File file) {
        File[] temporaryFilesArray = file.listFiles();
        if(temporaryFilesArray != null) {
            for (File f : temporaryFilesArray) {
                if (f.isDirectory()) transformDirectory(f);
                else if (f.isFile()) temporaryFileStorage.add(f);
            }
        } else temporaryFileStorage.add(file);
    }
}
//              C://Users//User//Desktop//GIT BASH