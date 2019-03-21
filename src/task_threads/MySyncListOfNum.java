package task_threads;

import java.util.ArrayList;
import java.util.List;

public class MySyncListOfNum {
    private final List<Integer> integerList = new ArrayList<>();

    public synchronized void addNote(int num) {
        integerList.add(num);
    }

    public synchronized List<Integer> getIntegerList() {
        return integerList;
    }
}
