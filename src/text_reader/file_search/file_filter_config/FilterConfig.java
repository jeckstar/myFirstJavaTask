package text_reader.file_search.file_filter_config;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FilterConfig {
    private String name = null;
    private String extension = null;
    private long size = 0;
    private long date = 0;
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    public void setName(String name) {
        this.name = name;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public void setDate(long date) {
        this.date = date;
    }
    public void print(){
        System.out.println(name+extension+size+date);
    }
}
