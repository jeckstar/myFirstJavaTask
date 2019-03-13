package text_reader.file_search;

import text_reader.file_search.file_filter_config.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class SearchMenu {

    public static void main(String[] args) throws IOException{
        final FilterMaster commandsSequence = createCommandsSequence();
        while (waitForTheNextCommand(commandsSequence)) {
        }
    }

    private static boolean waitForTheNextCommand(FilterMaster commandsSequence) {
        System.out.println();
        try {
            return commandsSequence.handleCommand();
        } catch (NoSuchCommandException e) {
            System.out.println("ERROR! Команда введена неверно! Введите корректную команду.");
            return true;
        }
    }

    private static FilterMaster createCommandsSequence() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileCatalog fileCatalog = new FileCatalog();
        File[] filesInCatalog = fileCatalog.getFileList(); //список файлов в каталоге
        FilteredFileList filteredFileList = new FilteredFileList(); // Которые подошли тут
        final DateRangeFilter dateRangeFilter = new DateRangeFilter(null, reader);
        final SizeRangeFilter sizeRenge = new SizeRangeFilter(dateRangeFilter, reader);
        final FileExtensionFilter extetsion = new FileExtensionFilter(sizeRenge, reader);
        return new NameFilter(extetsion, reader);
    }
    

}
//              "C://Users//User//Desktop//GIT BASH