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

public class plus_minus {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt).collect(toList());

        plusMinus(arr);

        bufferedReader.close();
    }

    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        int pos = 0, neg = 0, zero = 0;
        double posAvg = 0, negAvg = 0, zeroAvg = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) > 0) {
                ++pos;
            } else if (arr.get(i) < 0) {
                ++neg;
            } else {
                ++zero;
            }
        }
        posAvg = (double) pos / arr.size();
        negAvg = (double) neg / arr.size();
        zeroAvg = (double) zero / arr.size();
        System.out.printf("%.6f\n%.6f\n%.6f\n", posAvg, negAvg, zeroAvg);

    }
}
