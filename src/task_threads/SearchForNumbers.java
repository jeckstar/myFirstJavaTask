package task_threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchForNumbers {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static int fromNum = 0;
    private static int toNum = 0;
    private static int countOfThread = 0;
    private static List<Integer> integerList = new ArrayList<>();
    private static int path;


    public static void main(String[] args) throws IOException, InterruptedException {
        SearchForNumbers searchForNumbers = new SearchForNumbers();
        searchForNumbers.getRangeOfSearch();

        if (path == 1) searchForNumbers.seachingByFirstOption();
        else if (path == 2) searchForNumbers.seachingBySecondOption();
        for (Integer i : integerList) {
            System.out.println(i);
        }
    }

    private void getRangeOfSearch() throws IOException {
        System.out.println("Chose a path (1/2)");
        path = Integer.parseInt(reader.readLine());
        System.out.println("Search from:");
        fromNum = Integer.parseInt(reader.readLine());
        System.out.println("Search to");
        toNum = Integer.parseInt(reader.readLine());
        System.out.println("Count of thread");
        countOfThread = Integer.parseInt(reader.readLine());

    }

    private void seachingByFirstOption() throws InterruptedException {
        if (countOfThread > 1) {
            int step = (toNum - fromNum) / countOfThread;
            System.out.println(step);
            int threadCalling = 1;
            int startNum = fromNum;
            List<Thread> threadList = new LinkedList<>();
            for (int i = 0; i < countOfThread; i++) {
                System.out.println("Thread " + threadCalling++);
                threadList.add(this.firstOption(startNum, startNum + step));
                startNum += step;
            }
            for (Thread thread: threadList) {
                thread.start();
            }
            for (Thread thread: threadList) {
                thread.join();
            }
        } else if (countOfThread == 1) {
            Thread thread = this.firstOption(fromNum, toNum);
            thread.start();
            thread.join();
        }
    }

    private void seachingBySecondOption() throws InterruptedException {
        if (countOfThread > 1) {
            int step = (toNum - fromNum) / countOfThread;
            System.out.println(step);
            int threadCalling = 1;
            int startNum = fromNum;
            List<Thread> threadList = new LinkedList<>();
            for (int i = 0; i < countOfThread; i++) {
                System.out.println("Thread " + threadCalling++);
                threadList.add(this.secondOption(startNum, startNum + step));
                startNum += step;
            }
            for (Thread thread: threadList) {
                thread.start();
            }
            for (Thread thread: threadList) {
                thread.join();
            }
        } else if (countOfThread == 1) {
            Thread thread = this.secondOption(fromNum, toNum);
            thread.start();
            thread.join();
        }
    }

    private Thread firstOption(int fromNum, int toNum) {
        SearchFirstOption sfh = new SearchFirstOption(integerList, fromNum, toNum);
        return new Thread(sfh);
    }

    private Thread secondOption(int fromNum, int toNum) throws InterruptedException {
        SearchSecondOption ssh = new SearchSecondOption(integerList, fromNum, toNum);
        return new Thread(ssh);
    }
}
