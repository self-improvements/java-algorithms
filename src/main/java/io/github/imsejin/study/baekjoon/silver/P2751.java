package io.github.imsejin.study.baekjoon.silver;

import io.github.imsejin.study.meta.Problem;
import io.github.imsejin.study.meta.Tag;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Problem(tags = {
        Tag.SORTING,
})
public class P2751 {

    private static final int MAX_COUNT = 1000000;

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int count = Integer.parseInt(reader.readLine());

            // 0 <= |n| <= 1000000
            int[] negative = new int[MAX_COUNT + 1];
            int[] positiveOrZero = new int[MAX_COUNT + 2];

            for (int i = 0; i < count; i++) {
                int number = Integer.parseInt(reader.readLine());
                if (number < 0) {
                    negative[-number]++;
                } else {
                    positiveOrZero[number]++;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = negative.length - 1; i >= 0; i--) {
                if (negative[i] > 0) sb.append(-i).append('\n');
            }

            for (int i = 0; i < positiveOrZero.length; i++) {
                if (positiveOrZero[i] > 0) sb.append(i).append('\n');
            }

            System.out.println(sb);
        }
    }

}
