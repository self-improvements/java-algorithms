package io.github.imsejin.study.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P10989 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int count = Integer.parseInt(reader.readLine());

            solve1(reader, count);
        }
    }

    private static final int MAX_NUMBER = 10000;

    static void solve1(BufferedReader reader, int count) throws Exception {
        int[] counts = new int[MAX_NUMBER + 1];

        for (int i = 0; i < count; i++) {
            int n = Integer.parseInt(reader.readLine());
            counts[n]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < counts.length; i++) {
            for (int j = 0; j < counts[i]; j++) {
                sb.append(i).append('\n');
            }
        }

        System.out.println(sb);
    }

    static void solve2(BufferedReader reader, int count) throws Exception {
        int[] numbers = new int[count];
        for (int i = 0; i < count; i++) {
            int n = Integer.parseInt(reader.readLine());
            numbers[i] = n;
        }

        Arrays.sort(numbers);

        StringBuilder sb = new StringBuilder();
        for (int number : numbers) {
            sb.append(number).append('\n');
        }

        System.out.println(sb);
    }

}
