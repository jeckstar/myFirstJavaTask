package task_threads.task_executors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SearchForNumbersByExecutors {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static int fromNum = 0;
    private static int toNum = 0;

    public static void main(String[] args) throws IOException, InterruptedException {
        SearchForNumbersByExecutors searching = new SearchForNumbersByExecutors();
        searching.getКangeOfSearch();
        ArrayList<Integer> integerList = new ArrayList<>();

        SearchFirstHalfByExecutors sfh = new SearchFirstHalfByExecutors(integerList, fromNum, toNum);
        SearchSecondHalfByExecutors ssh = new SearchSecondHalfByExecutors(integerList, fromNum, toNum);
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(sfh);
        executorService.execute(ssh);
        executorService.shutdown();
        TimeUnit.SECONDS.sleep(4);
        for (Integer i : integerList) {
            System.out.println(i);
        }
    }

    private void getКangeOfSearch() throws IOException {
        System.out.println("Search from:");
        fromNum = Integer.parseInt(reader.readLine());
        System.out.println("Search to");
        toNum = Integer.parseInt(reader.readLine());
    }
}

