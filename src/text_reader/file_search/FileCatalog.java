package text_reader.file_search;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileCatalog {
    private String directoryName;
    private File catalog;
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public FileCatalog() throws IOException {
        catalog = createFileCatalog();
    }

    private File createFileCatalog() throws IOException {
        showRequirements();
        directoryName = reader.readLine();
        File directory = new File(directoryName);
        if (directory.isDirectory()) {
            System.out.println("Каталог прошел проверку.");
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
        return catalog.listFiles();
    }

}
//= new File("C://Users//User//Desktop//GIT BASH");