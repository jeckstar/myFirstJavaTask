package text_reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

public class EasyFileReader {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String textPath = "";
        try {
            textPath = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            TextFile file = new TextFile(textPath);
            for (String line : file) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
        }
    }


}
///      C:\Users\User\Desktop\GIT BASH\GIT.txt