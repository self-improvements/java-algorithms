package io.github.imsejin.study.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P18110 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int[] difficulties = new int[Integer.parseInt(reader.readLine())];

            for (int i = 0; i < difficulties.length; i++) {
                int difficulty = Integer.parseInt(reader.readLine());
                difficulties[i] = difficulty;
            }

            int answer = solve(difficulties);
            System.out.println(answer);
        }
    }

    static int solve(int[] difficulties) {
        if (difficulties.length == 0) return 0;

        final int excluded = -1;
        Arrays.sort(difficulties);
        int excludedCount = (int) Math.round(difficulties.length * 0.15);

        for (int i = 0; i < excludedCount; i++) {
            difficulties[i] = excluded;
            difficulties[difficulties.length - 1 - i] = excluded;
        }

        int sum = 0;
        int count = 0;
        for (int difficulty : difficulties) {
            if (difficulty == excluded) {
                continue;
            }

            sum += difficulty;
            count++;
        }

        return (int) Math.round((double) sum / count);
    }

}
