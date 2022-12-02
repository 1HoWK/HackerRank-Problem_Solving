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

public class mini_max_sum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt).collect(toList());

        miniMaxSum(arr);

        bufferedReader.close();
    }

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        long miniSum = 0, maxSum = 0, currentMin = arr.get(0), currentMax = arr.get(0);

        for (int i = 0; i < arr.size(); i++) {
            // find greatest
            if (arr.get(i) > currentMax) {
                currentMax = arr.get(i);
            }
            // find smallest
            if (arr.get(i) < currentMin) {
                currentMin = arr.get(i);
            }
            maxSum += arr.get(i);
            miniSum += arr.get(i);
        }
        maxSum -= currentMax;
        miniSum -= currentMin;
        System.out.println(maxSum + " " + miniSum);
    }
}
