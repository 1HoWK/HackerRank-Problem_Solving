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

public class time_conversion {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();

    }

    public static String timeConversion(String s) {
        // Write your code here
        // Get hours
        // '0' = 48 in ascii code
        // string is an array of char datatypes which the compiler translates into ASCII
        // values
        // minus '0' is to get back decimal value
        StringBuilder sb = new StringBuilder();
        int h0 = (int) s.charAt(0) - '0';
        int h1 = (int) s.charAt(1) - '0';
        // to get whole number
        int hh = (h0 * 10 + h1 % 10);

        String convertedTime = "";
        // If time is in "AM"
        if (s.charAt(8) == 'A') {
            if (hh == 12) {
                sb.append("00");
                for (int i = 2; i < 8; i++) {
                    sb.append(s.charAt(i));

                }
            } else {
                sb.append(String.format("%02d", hh));
                for (int i = 2; i < 8; i++) {
                    sb.append(s.charAt(i));
                }
            }
        }

        // If time is in "PM"
        else {
            if (hh == 12) {
                sb.append("12");
                for (int i = 2; i < 8; i++) {
                    sb.append(s.charAt(i));
                }
            } else {
                int hours = hh + 12;
                sb.append(hours);
                for (int i = 2; i < 8; i++) {
                    sb.append(s.charAt(i));
                }

            }
        }
        convertedTime = sb.toString();
        return convertedTime;
    }
}
