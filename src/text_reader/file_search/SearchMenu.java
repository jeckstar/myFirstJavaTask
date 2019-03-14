package text_reader.file_search;

import text_reader.file_search.file_filter_config.*;
import text_reader.file_search.file_filter_config.ConfigFilter.AddConfig;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SearchMenu {

    public static void main(String[] args) throws IOException {
        final FilterMaster commandsSequence = createCommandsSequence();
        while (waitForTheNextCommand(commandsSequence)) {
        }
    }

    private static boolean waitForTheNextCommand(FilterMaster commandsSequence) {
        System.out.println();
        try {
            return commandsSequence.handleCommand();
        } catch (UnsupportedOperationException e) {
            System.out.println("Поиск завершен.");
            return false;
        }
    }

    private static FilterMaster createCommandsSequence() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        AddConfig addConfig = new AddConfig();
        FileCatalog fileCatalog = new FileCatalog();
        File[] filesInCatalog = fileCatalog.getFileList(); //список файлов в каталоге
        for (File f: filesInCatalog) {
            System.out.println(f);
        }
        FilteredFileList filteredFileList = new FilteredFileList(); // Которые подошли тут
        final Filter filter = new Filter(BaseFilter.NO_OP_CHAIN, addConfig, filesInCatalog, filteredFileList);
        final DateRangeConfig dateRangeFilter = new DateRangeConfig(filter, reader, addConfig);
        final SizeRangeConfig sizeRenge = new SizeRangeConfig(dateRangeFilter, reader, addConfig);
        final FileExtensionConfig extetsion = new FileExtensionConfig(sizeRenge, reader, addConfig);
        return new NameConfig(extetsion, reader, addConfig);
    }
}
//              C://Users//User//Desktop//GIT BASH