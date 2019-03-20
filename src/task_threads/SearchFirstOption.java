package task_threads;

import java.util.List;

public class SearchFirstOption implements Runnable {
    private List<Integer> integerList;
    private int fromNum;
    private int toNum;


    public SearchFirstOption(List<Integer> integerList, int fromNum, int toNum) {
        this.integerList = integerList;
        this.fromNum = fromNum;
        this.toNum = toNum;
    }


    @Override
    public void run() {
        System.out.println("[" + fromNum + " " + toNum + "]");
        for (int i = fromNum; i < toNum; i++) {
            boolean isPrime = true;
            int n = i;
            for (int j = 2; j < n; j++) {
                if ((n % j) == 0) {
                    isPrime = false;
                }
            }
            if (isPrime && n > 1) integerList.add(n);
        }
    }
}
