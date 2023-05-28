package io.github.imsejin.study.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1292 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());

            int answer = solve(start, end);
            System.out.println(answer);
        }
    }

    static int solve(int start, int end) {
        int sum = 0;

        for (int i = 1, num = 1, count = 0; i <= end; i++) {
            count++;

            if (i >= start) {
                sum += num;
            }

            if (num == count) {
                count = 0;
                num++;
            }
        }

        return sum;
    }

}
