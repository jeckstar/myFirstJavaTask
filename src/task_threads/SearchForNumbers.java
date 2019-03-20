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
            for (int i = 0; i < countOfThread; i++) {
                System.out.println("Thread " + threadCalling++);
                this.firstOption(startNum, startNum + step);
                startNum += step;
            }
        } else if (countOfThread == 1) this.firstOption(fromNum, toNum);
    }

    private void seachingBySecondOption() throws InterruptedException {
        if (countOfThread > 1) {
            int step = (toNum - fromNum) / countOfThread;
            System.out.println(step);
            int threadCalling = 1;
            int startNum = fromNum;
            for (int i = 0; i < countOfThread; i++) {
                System.out.println("Thread " + threadCalling++);
                this.secondOption(startNum, startNum + step);
                startNum += step;
            }
        } else if (countOfThread == 1) this.secondOption(fromNum, toNum);
    }

    private void firstOption(int fromNum, int toNum) throws InterruptedException {
        SearchFirstOption sfh = new SearchFirstOption(integerList, fromNum, toNum);
        Thread threadF = new Thread(sfh);
        Date start = new Date();
        threadF.start();
        threadF.join();
        Date finish = new Date();
        long timeOfRun = finish.getTime() - start.getTime();
        System.out.println("\n" + (double) timeOfRun / 1000);
    }

    private void secondOption(int fromNum, int toNum) throws InterruptedException {
        SearchSecondOption ssh = new SearchSecondOption(integerList, fromNum, toNum);
        Thread threadS = new Thread(ssh);
        Date start = new Date();
        threadS.start();
        threadS.join();
        Date finish = new Date();
        long timeOfRun = finish.getTime() - start.getTime();
        System.out.println("\n" + (double) timeOfRun / 1000);
    }

    private void firstOption1() throws InterruptedException {
        List<Integer> integerList = new ArrayList<>();
        int toNumLocal = changeToNum();
        int fromNumLocal = toNumLocal;
        SearchFirstOption sfh = new SearchFirstOption(integerList, fromNum, toNumLocal);
        SearchFirstOption sfh2 = new SearchFirstOption(integerList, fromNumLocal, toNum);
        Thread threadF = new Thread(sfh);
        Thread threadF2 = new Thread(sfh2);
        Date start = new Date();
        threadF.start();
        threadF2.start();
        threadF.join();
        threadF2.join();
        Date finish = new Date();
        long timeOfRun = finish.getTime() - start.getTime();
        for (Integer i : integerList) {
            System.out.println(i);
        }
        System.out.println("\n" + (double) timeOfRun / 1000);
        TimeUnit.SECONDS.sleep(1);
        List<Integer> newIntList = new LinkedList<>();
        for (int i = 1; i < 10000; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if ((i % j) == 0) {
                    isPrime = false;
                }
            }
            if (isPrime && i > 1) newIntList.add(i);
        }
        final ArrayList<Integer> integers = new ArrayList<>(newIntList);
        System.out.println("Integers size");
        System.out.println(integerList.size());
        System.out.println("Integers size");
        System.out.println(integers.size());
        integers.removeAll(integerList);
        System.out.println("------------------------");
        integers.forEach(System.out::println);
    }

    private int changeToNum() {
        return toNum - (toNum - fromNum) / 2;
    }


}
