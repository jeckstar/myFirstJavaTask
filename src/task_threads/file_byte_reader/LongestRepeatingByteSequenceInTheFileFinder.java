package task_threads.file_byte_reader;

import java.io.File;
import java.io.IOException;

public class LongestRepeatingByteSequenceInTheFileFinder {

    public static void main(String[] args) throws InterruptedException {
        EasyFileReader fileReader = new EasyFileReader();
        AdditionalSearchTask searchThread = new AdditionalSearchTask(fileReader);
        Thread byteFinderThread = new Thread(searchThread);
        byteFinderThread.start();
        fileReader.setFile();
        LoadingProgress loading = searchThread.getLoadingInfo();
        loading.printLoadingProgress();
    }
}

///   C://Users//User//Desktop//GIT BASH//GIT.txt
//   C:\Users\User\IdeaProjects\firstTask\.idea\workspace.xml
//          C://Users//User//Desktop//GIT BASH//команды.txt
