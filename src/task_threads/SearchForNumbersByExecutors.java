package task_threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SearchForNumbersByExecutors {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static int fromNum = 0;
    private static int toNum = 0;
    private static int countOfExecutors = 0;
    private static List<Integer> integerList = new ArrayList<>();
    private static int path;

    public static void main(String[] args) throws IOException, InterruptedException {
        SearchForNumbersByExecutors searching = new SearchForNumbersByExecutors();
        searching.getRangeOfSearch();
        if (path == 1) searching.seachingByFirstOption();
        else if (path == 2) searching.seachingBySecondOption();
        //TimeUnit.SECONDS.sleep(1);
        for (Integer i : integerList) {
            System.out.println(i);
        }
    }

    private void seachingByFirstOption() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        if (countOfExecutors > 1) {
            int step = (toNum - fromNum) / countOfExecutors;
            System.out.println(step);
            int threadCalling = 1;
            int startNum = fromNum;
            for (int i = 0; i < countOfExecutors; i++) {
                System.out.println("Executor " + threadCalling++);
                this.firstOption(executorService, startNum, startNum + step);
                startNum += step;
            }
        } else if (countOfExecutors == 1) this.firstOption(executorService, fromNum, toNum);
        executorService.shutdown();
    }

    private void seachingBySecondOption() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        if (countOfExecutors > 1) {
            int step = (toNum - fromNum) / countOfExecutors;
            System.out.println(step);
            int threadCalling = 1;
            int startNum = fromNum;
            for (int i = 0; i < countOfExecutors; i++) {
                System.out.println("Executor " + threadCalling++);
                this.secondOption(executorService, startNum, startNum + step);
                startNum += step;
            }
        } else if (countOfExecutors == 1) this.secondOption(executorService, fromNum, toNum);
        executorService.shutdown();
    }

    private void secondOption(ExecutorService executorService, int fromNum, int toNum) {
     //   SearchSecondOption sfh = new SearchSecondOption(integerList, fromNum, toNum);
      //  executorService.execute(sfh);
    }

    private void firstOption(ExecutorService executorService, int fromNum, int toNum) {
        //SearchFirstOption sfh = new SearchFirstOption(integerList, fromNum, toNum);
        //executorService.execute(sfh);
    }


    private void getRangeOfSearch() throws IOException {
        System.out.println("Chose a path (1/2)");
        path = Integer.parseInt(reader.readLine());
        System.out.println("Search from:");
        fromNum = Integer.parseInt(reader.readLine());
        System.out.println("Search to");
        toNum = Integer.parseInt(reader.readLine());
        System.out.println("Count of Executor");
        countOfExecutors = Integer.parseInt(reader.readLine());

    }
}

