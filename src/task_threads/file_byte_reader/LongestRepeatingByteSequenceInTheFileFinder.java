package task_threads.file_byte_reader;

import java.io.File;
import java.io.IOException;

public class LongestRepeatingByteSequenceInTheFileFinder {


    public static void main(String[] args) throws IOException {
        FileConvertToByteArray fileConvertToByteArray = new FileConvertToByteArray();
        EasyFileReader fileReader = new EasyFileReader();
        File file = fileReader.getFile();
        byte[] fileByteArray = fileConvertToByteArray.covertFileToByteArray(file);
        for (byte b: fileByteArray) {
            System.out.println(b);
        }
    }
}

//   C://Users//User//Desktop//GIT BASH//GIT.txt
