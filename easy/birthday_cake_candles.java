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

public class birthday_cake_candles {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int candlesCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> candles = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt).collect(toList());

		int result = birthdayCakeCandles(candles);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}

	public static int birthdayCakeCandles(List<Integer> candles) {
		// Write your code here
		int num = 0, firstNum = candles.get(0);
		for (int i = 0; i < candles.size(); i++) {
			if (candles.get(i) > firstNum) {
				firstNum = candles.get(i);
			}
		}
		for (int i = 0; i < candles.size(); i++) {
			if (candles.get(i) == firstNum) {
				++num;
			}
		}
		return num;

	}
}
