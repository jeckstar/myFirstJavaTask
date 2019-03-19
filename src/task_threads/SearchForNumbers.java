package task_threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class SearchForNumbers {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public ArrayList<Integer> integerList = new ArrayList<Integer>();
    private static int fromNum = 0;
    private static int toNum = 0;

    public static void main(String[] args) throws IOException {
        SearchForNumbers searchForNumbers = new SearchForNumbers();
        searchForNumbers.getКangeOfSearch();

        SearchFirstHalf sfh = new SearchFirstHalf(fromNum, toNum);
        SearchSecondHalf ssh = new SearchSecondHalf(fromNum, toNum);
        Thread threadF = new Thread(sfh);
        Thread threadS = new Thread(ssh);
        threadF.start();
        threadS.start();

        for (Integer i:
                searchForNumbers.integerList) {
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
