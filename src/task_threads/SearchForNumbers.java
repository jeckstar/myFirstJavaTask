package task_threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SearchForNumbers {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private List<Integer> integerList = new ArrayList<>();
    private static int fromNum = 0;
    private static int toNum = 0;

    public static void main(String[] args) throws IOException {
        SearchForNumbers searchForNumbers = new SearchForNumbers();
        searchForNumbers.getКangeOfSearch();

        SearchFirstHalf sfn = new SearchFirstHalf(fromNum, toNum);
        SearchSecondHalf ssh = new SearchSecondHalf(fromNum, toNum);
        Thread threadF = new Thread(sfn);
        Thread threadS = new Thread(ssh);
        threadF.start();
        threadS.start();

    }

    private void getКangeOfSearch() throws IOException {
        System.out.println("Search from:");
        fromNum = Integer.parseInt(reader.readLine());
        System.out.println("Search to");
        toNum = Integer.parseInt(reader.readLine());
    }
}
