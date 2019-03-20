package task_threads;

import java.util.ArrayList;
import java.util.List;

public class SearchSecondOption implements Runnable {
    private List<Integer> integerList;
    private int fromNum;
    private int toNum;


    public SearchSecondOption(List<Integer> integerList, int fromNum, int toNum) {
        this.integerList = integerList;
        this.fromNum = fromNum;
        this.toNum = toNum;
    }

    @Override
    public void run() {
        List<Integer> innerList = new ArrayList<>();
        System.out.println("[" + fromNum + " " + toNum + "]");
        for (int i = fromNum; i <= toNum; i++) {
            boolean isPrime = true;
            int n = i;
            for (int j = 2; j < n; j++) {
                if ((n % j) == 0) {
                    isPrime = false;
                    continue;
                }
            }
            if (isPrime && n > 1) innerList.add(n);
        }
        integerList.addAll(innerList);
//        for (Integer i :
//                integerList) {
//            System.out.println(i);
//        }
    }

}
