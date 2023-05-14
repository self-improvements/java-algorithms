package io.github.imsejin.study.baekjoon.bronze;

import java.io.*;
import java.util.Arrays;

public class P2675 {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                PrintWriter writer = new PrintWriter(
                        new BufferedWriter(new OutputStreamWriter(System.out)))) {
            int[] numbers = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt)
                    .toArray();

            String answer = solve(numbers);
            writer.println(answer);
        }
    }

    private static String solve(int[] numbers) {
        if (numbers[0] == 1) {
            int temp = numbers[0];
            for (int number : numbers) {
                if (number != temp) {
                    return "mixed";
                }

                temp++;
            }

            return "ascending";
        } else if (numbers[0] == 8) {
            int temp = numbers[0];
            for (int number : numbers) {
                if (number != temp) {
                    return "mixed";
                }

                temp--;
            }

            return "descending";
        } else {
            // Fast return
            return "mixed";
        }
    }

}
