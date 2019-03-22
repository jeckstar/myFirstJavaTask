package task_threads.file_byte_reader;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class ByteFinder {
    private List<Byte> fileByteArray;
    private List<ValueOfString> valueOfStringsList = new ArrayList<>();
    public int loadCount = 50;
    private LoadingProgress loading;

    public void setFileByteArray(List<Byte> fileByteArray, LoadingProgress loading) {
        this.fileByteArray = fileByteArray;
        this.loading = loading;
    }

    public void findLongestRepeatingByte() {
        createValueOfStringList();
        int step = valueOfStringsList.size() / 50;
        int goLoad = 0;
        ValueOfString maxCount = valueOfStringsList.get(0);
        for (int j = 1; j < valueOfStringsList.size(); j++) {
            for (int i = 1; i < valueOfStringsList.size(); i++) {
                if (valueOfStringsList.get(i).getCount() > maxCount.getCount() && valueOfStringsList.get(i).getaByte() != maxCount.getaByte()) {
                    maxCount = valueOfStringsList.get(i);
                }
            }
            goLoad++;
            if (goLoad >= step && loadCount < 101) {
                loading.startLoading(loadCount);
                loadCount++;
                goLoad = 0;
            }
        }
        loadCount = 0;
        System.out.println(maxCount);
        int indexInArray = fileByteArray.indexOf(maxCount.getaByte());
        getFirstAndSecondIndex(indexInArray);
    }

    private void createValueOfStringList() {
        int count = 0;
        int step = fileByteArray.size() / 50;
        int goLoad = 0;
        for (int i = 0; i < fileByteArray.size(); i++) {
            for (int j = 0; j < fileByteArray.size(); j++) {
                if (fileByteArray.get(i).equals(fileByteArray.get(j))) {
                    count++;
                }
            }
            goLoad++;
            if (goLoad >= step && loadCount < 51) {
                loading.startLoading(loadCount);
                loadCount++;
                goLoad = 0;
            }
            valueOfStringsList.add(new ValueOfString(fileByteArray.get(i), count));
            count = 0;
        }
    }

    private void getFirstAndSecondIndex(int indexInArray) {
        long firstByteIndex = 0;
        for (int i = 0; i < indexInArray; i++) {
            firstByteIndex += fileByteArray.get(i);
        }
        long secondByteIndex = 0;
        int index = 0;
        for (int i = indexInArray; i < fileByteArray.size(); i++) {
            for (int j = indexInArray + 1; j < fileByteArray.size(); j++) {
                if (fileByteArray.get(i).equals(fileByteArray.get(j))) {
                    index = j;
                    break;
                }
            }
        }
        for (int i = indexInArray; i < index; i++) {
            secondByteIndex += fileByteArray.get(i);
        }
        System.out.println(indexInArray + "||" + index);
        System.out.println(firstByteIndex + " & " + secondByteIndex);
    }

}
