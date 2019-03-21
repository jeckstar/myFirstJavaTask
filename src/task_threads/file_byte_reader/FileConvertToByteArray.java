package task_threads.file_byte_reader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileConvertToByteArray {
    private File file;

    public FileConvertToByteArray(){
    }

    public byte[] covertFileToByteArray(File file) throws IOException {
        return Files.readAllBytes(file.toPath());
    }
}
