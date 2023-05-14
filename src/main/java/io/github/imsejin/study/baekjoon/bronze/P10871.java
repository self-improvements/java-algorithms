package io.github.imsejin.study.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P10871 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] strings = reader.readLine().split(" ");
            int x = Integer.parseInt(strings[1]);
            int[] numbers = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            StringBuilder sb = new StringBuilder();
            for (int number : numbers) {
                if (number < x) sb.append(number).append(' ');
            }

            System.out.println(sb);
        }
    }

}
