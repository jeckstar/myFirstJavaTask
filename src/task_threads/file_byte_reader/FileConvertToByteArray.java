package task_threads.file_byte_reader;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class FileConvertToByteArray {

    public FileConvertToByteArray() {
    }

    public List<Byte> covertFileToByteArray(File file) throws IOException {
        List<Byte> bytesList = new ArrayList<>();
        FileReader fin = new FileReader(file);
        int elemenrOfFile;
        while ((elemenrOfFile = fin.read()) != -1) {
            bytesList.add((byte) elemenrOfFile);
        }
        System.out.println(bytesList.size());
        return bytesList;
    }


}
