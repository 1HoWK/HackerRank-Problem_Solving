package easy;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class diagonal_difference {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt)
                        .collect(toList()));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = diagonalDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        // list in a list
        // arr : [{1,2,3},{4,5,6},{9,8,9}]
        // int ltrDiagonal = 0, rtlDiagonal = 0;
        //
        // for (int i = 0; i < arr.size(); i++) {
        // ltrDiagonal += arr.get(i).get(i);
        // rtlDiagonal += arr.get(i).get(arr.size()-(i+1));
        // }
        //
        // int diff = Math.abs(ltrDiagonal - rtlDiagonal);
        // return diff;

        int diagonal = 0;

        for (int i = 0; i < arr.size(); i++) {
            diagonal += arr.get(i).get(i);
            diagonal -= arr.get(i).get(arr.size() - (i + 1));
        }

        return Math.abs(diagonal);

    }
}
