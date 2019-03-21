package task_threads;


public class SearchSecondOption implements Runnable {
    private MySyncListOfNum mySyncListOfNum;
    private int fromNum;
    private int toNum;
    private MySyncListOfNum innerList = new MySyncListOfNum();


    public SearchSecondOption(MySyncListOfNum mySyncListOfNum, int fromNum, int toNum) {
        this.mySyncListOfNum = mySyncListOfNum;
        this.fromNum = fromNum;
        this.toNum = toNum;
    }

    @Override
    public void run() {
        System.out.println("[" + fromNum + " " + toNum + ")");
        for (int i = fromNum; i < toNum; i++) {
            boolean isPrime = true;
            int n = i;
            for (int j = 2; j < n; j++) {
                if ((n % j) == 0) {
                    isPrime = false;
                }
            }
            if (isPrime && n > 1) innerList.addNote(n);
        }
        mySyncListOfNum.getIntegerList().addAll(innerList.getIntegerList());
    }

}
