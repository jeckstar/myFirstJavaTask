package text_reader;

import java.io.*;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class TextFile implements Iterable<String> {
    private String path;
    private BufferedReader reader;

    public TextFile(String path) throws FileNotFoundException {
        this.path = path;
        this.reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
    }

    public String getPath() {
        return path;
    }


    public void readFile() {
        try{
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
            String strLine;
            while ((strLine = reader.readLine()) != null){
                System.out.println(strLine);
            }
        }catch (IOException e){
            System.out.println("Ошибка");
        }

    }

    @Override
    public Iterator<String> iterator() {
        return new TextIterator();
    }

    private class TextIterator implements Iterator {
        private String nextLine = null;

        @Override
        public boolean hasNext() {
            try {
                if (nextLine != null) {
                    return true;
                } else {
                    nextLine = reader.readLine();
                    return (nextLine != null);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }

        @Override
        public Object next() {
            if (nextLine != null || hasNext()) {
                String line = nextLine;
                nextLine = null;
                return line;
            } else {
                throw new NoSuchElementException();
            }
        }
    }
}
