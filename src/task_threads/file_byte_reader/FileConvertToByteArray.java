package task_threads.file_byte_reader;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class FileConvertToByteArray {
    private final List<Byte> bytesList = new ArrayList<>();
    private File file;

    public  void setFile(File file) {
            this.file = file;
    }

    public List<Byte> covertFileToByteArray() throws IOException {
        FileReader fin = new FileReader(file);
        int elementOfFile;
        while ((elementOfFile = fin.read()) != -1) {
            bytesList.add((byte) elementOfFile);
        }
        System.out.println(bytesList.size());
        return bytesList;
    }
}
