package task_threads.file_byte_reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class EasyFileReader {
    private File file;
    private String path;


    public EasyFileReader(){
        this.file = new File(getPath());
    }

    public File getFile(){
        return file;
    }

    private boolean checkFilePath() {
        File file = new File(path);
        return file.exists() && file.isFile();
    }

    private String getPath(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите путь файла!");
        try {
            path = reader.readLine();
            if(!checkFilePath()){
                System.out.println("NO!");
                return getPath();
            }
            else return path;
        } catch (IOException e) {
            System.out.println("Не верный ввод, повторите!!!");
            return getPath();
        }
    }
}
