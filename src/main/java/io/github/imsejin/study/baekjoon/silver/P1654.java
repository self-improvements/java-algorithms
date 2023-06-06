package io.github.imsejin.study.baekjoon.silver;

import io.github.imsejin.study.meta.Problem;
import io.github.imsejin.study.meta.Tag;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@Problem(tags = {
        Tag.SEARCH,
})
public class P1654 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int cableCount = Integer.parseInt(tokenizer.nextToken());
            int targetCount = Integer.parseInt(tokenizer.nextToken());

            int[] cables = new int[cableCount];
            for (int i = 0; i < cables.length; i++) {
                int length = Integer.parseInt(reader.readLine());
                cables[i] = length;
            }

            long answer = solve1(cables, targetCount);
            System.out.println(answer);
        }
    }

    /**
     * Parametric Search
     */
    static long solve1(int[] cables, int targetCount) {
        // Calculates the sum of cables.
        long sum = 0;
        for (int cable : cables) {
            sum += cable;
        }

        long low = 1;
        long high = sum / targetCount;

        while (low <= high) {
            long mid = (low + high) / 2;

            if (isCapable(cables, mid, targetCount)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return high;
    }

    static long solve2(int[] cables, int targetCount) {
        // Calculates the sum of cables.
        long sum = 0;
        for (int cable : cables) {
            sum += cable;
        }

        // Starts to the best fit length.
        long cableLength = (int) (sum / targetCount);

        while (true) {
            long cableCount = getCableCount(cables, cableLength);

            if (cableCount >= targetCount) {
                break;
            }

            // 주어진 케이블을 1cm씩 자르면서 조건에 충족할 때까지 반복한다.
            cableLength--;
        }

        return cableLength;
    }

    private static boolean isCapable(int[] cables, long cableLength, int targetCount) {
        long cableCount = getCableCount(cables, cableLength);
        return cableCount >= targetCount;
    }

    private static long getCableCount(int[] cables, long cableLength) {
        long cableCount = 0;

        for (int cable : cables) {
            cableCount += cable / cableLength;
        }

        return cableCount;
    }

}
