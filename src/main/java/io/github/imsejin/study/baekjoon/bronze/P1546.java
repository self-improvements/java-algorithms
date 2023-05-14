package io.github.imsejin.study.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;

public class P1546 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))) {
            reader.readLine();
            int[] scores = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
            float average = solve(scores);

            writer.println(average);
        }
    }

    private static float solve(int[] scores) {
        int highestScore = scores[scores.length - 1];
        float sum = 0;

        for (float score : scores) {
            sum += score / highestScore * 100;
        }

        return sum / scores.length;
    }

}
