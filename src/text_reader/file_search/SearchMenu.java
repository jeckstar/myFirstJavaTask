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
        FilterConfig config = new FilterConfig();
        final DateRangeFilterConfig dateRangeFilter = new DateRangeFilterConfig(null, reader, config);
        final SizeRangeFilterConfig sizeRenge = new SizeRangeFilterConfig(dateRangeFilter, reader, config);
        final FileExtensionFilterConfig extetsion = new FileExtensionFilterConfig(sizeRenge, reader, config);
        return new NameFilterConfig(extetsion, reader, config);
    }

}
//              "C://Users//User//Desktop//GIT BASH