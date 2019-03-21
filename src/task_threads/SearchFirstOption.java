package task_threads;


public class SearchFirstOption implements Runnable {
    private MySyncListOfNum mySyncListOfNum;
    private int fromNum;
    private int toNum;


    public SearchFirstOption(MySyncListOfNum mySyncListOfNum, int fromNum, int toNum) {
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
            if (isPrime && n > 1) mySyncListOfNum.addNote(n);
        }
    }
}
