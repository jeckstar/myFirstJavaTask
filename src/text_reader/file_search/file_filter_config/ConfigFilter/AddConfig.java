package text_reader.file_search.file_filter_config.ConfigFilter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

public class AddConfig {

    private String name = null;
    private String type = null;
    private long fromSize = 0;
    private long toSize = 0;
    private Date fromDate = null;
    private Date toDate = null;

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setFromSize(long fromSize) {
        this.fromSize = fromSize;
    }

    public void setToSize(long toSize) {
        this.toSize = toSize;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public long getFromSize() {
        return fromSize;
    }

    public long getToSize() {
        return toSize;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public Date getToDate() {
        return toDate;
    }
}
