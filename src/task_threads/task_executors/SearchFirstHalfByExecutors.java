package task_threads.task_executors;

import java.util.List;

public class SearchFirstHalfByExecutors implements Runnable {
    private List<Integer> integerList;
    private int fromNum;
    private int toNum;


    public SearchFirstHalfByExecutors(List<Integer> integerList, int fromNum, int toNum) {
        this.integerList = integerList;
        this.fromNum = fromNum;
        this.toNum = toNum;
    }

    private void changeToNum() {
        toNum = toNum - (toNum - fromNum) / 2;
    }

    @Override
    public void run() {
        changeToNum();
        System.out.println("[" + fromNum + " " + toNum + ")");
        for (int i = fromNum; i < toNum; i++) {
            boolean isPrime = true;
            int n = i;
            for (int j = 2; j < n; j++) {
                if ((n % j) == 0) {
                    isPrime = false;
                    continue;
                }
            }
            if (isPrime && n > 1) integerList.add(n);
        }
        for (Integer i :
                integerList) {
            System.out.println(i);
        }
    }
}

