package task_threads.file_byte_reader;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class AdditionalSearchTask implements Runnable {
    private EasyFileReader easyFileReader;
    private File file;
    private FileConvertToByteArray fileConvertToByteArray = new FileConvertToByteArray();
    private ByteFinder byteFinder = new ByteFinder();
    private List<Byte> byteList;
    private LoadingProgress loading = new LoadingProgress();

    public AdditionalSearchTask(EasyFileReader easyFileReader) {
        this.easyFileReader = easyFileReader;
    }

    @Override
    public void run() {
        System.out.println("- Дополнительный Thread запущен.\n" +
                "- " + Thread.currentThread().getName() + " Находиться в ожидании.");
        while (true) {
            file = easyFileReader.getFile();
            fileConvertToByteArray.setFile(file);
            try {
                byteList = fileConvertToByteArray.covertFileToByteArray();
            } catch (IOException e) {
                e.printStackTrace();
            }
            byteFinder.setFileByteArray(byteList, loading);
            byteFinder.findLongestRepeatingByte();
            easyFileReader.setFile();
        }
    }

    public LoadingProgress getLoadingInfo() {
        return loading;
    }
}
