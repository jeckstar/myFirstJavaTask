package task_threads.search_num_byexecutors;

import task_threads.MySyncListOfNum;
import task_threads.SearchFirstOption;
import task_threads.SearchSecondOption;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SearchForNumbersByExecutors {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static int fromNum = 0;
    private static int toNum = 0;
    private static int countOfExecutors = 0;
    private static MySyncListOfNum mySyncListOfNum = new MySyncListOfNum();
    //private static List<Integer> integerList = new ArrayList<>();
    private static int path;

    public static void main(String[] args) throws IOException, InterruptedException {
        SearchForNumbersByExecutors searching = new SearchForNumbersByExecutors();
        searching.getRangeOfSearch();
        if (path == 1) searching.seachingByFirstOption();
        else if (path == 2) searching.seachingBySecondOption();
        TimeUnit.SECONDS.sleep(2);
        for (Integer i : mySyncListOfNum.getIntegerList()) {
            System.out.println(i);
        }
        List<Integer> integers = new ArrayList<>();
        for (int i = 1; i < 10000; i++) {
            boolean isPrime = true;
            int n = i;
            for (int j = 2; j < n; j++) {
                if ((n % j) == 0) {
                    isPrime = false;
                }
            }
            if (isPrime && n > 1) integers.add(n);
        }
        System.out.println("1 - " + mySyncListOfNum.getIntegerList().size());
        System.out.println("2 - " + integers.size());
        integers.removeAll(mySyncListOfNum.getIntegerList());
        for (Integer i : integers) {
            System.out.println(i);
        }
        System.out.println(integers.size());
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
                if ((i == countOfExecutors - 1) && (toNum > startNum)) {
                    this.firstOption(executorService, startNum, toNum);
                }
            }
        } else if (countOfExecutors == 1) this.firstOption(executorService, fromNum, toNum);
        executorService.shutdown();
    }

    private void firstOption(ExecutorService executorService, int fromNum, int toNum) {
        SearchFirstOption sfh = new SearchFirstOption(mySyncListOfNum, fromNum, toNum);
        executorService.execute(sfh);
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
                if ((i == countOfExecutors - 1) && (toNum > startNum)) {
                    this.secondOption(executorService, startNum, toNum);
                }
            }
        } else if (countOfExecutors == 1) this.secondOption(executorService, fromNum, toNum);
        executorService.shutdown();
    }

    private void secondOption(ExecutorService executorService, int fromNum, int toNum) {
        SearchSecondOption sfh = new SearchSecondOption(mySyncListOfNum, fromNum, toNum);
        executorService.execute(sfh);
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

