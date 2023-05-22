package io.github.imsejin.study.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2775 {

    private static final int[][] cache = new int[15][14];

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int testCaseCount = Integer.parseInt(reader.readLine());

            for (int i = 0; i < cache[0].length; i++) {
                cache[0][i] = i + 1;
            }

            for (int i = 0; i < testCaseCount; i++) {
                int k = Integer.parseInt(reader.readLine());
                int n = Integer.parseInt(reader.readLine());

                int answer = solve(k, n);
                System.out.println(answer);
            }
        }
    }

    static int solve(int k, int n) {
        for (int i = 0; i < cache[0].length; i++) {
            cache[0][i] = i + 1;
        }

        if (n == 1) return 1;
        if (cache[k][n - 1] > 0) return cache[k][n - 1];

        for (int i = 0; i < cache[k].length; i++) {
            int sum = 0;
            for (int j = 0; j <= i; j++) {
                sum += cache[i][j];
            }

            cache[k][i] = sum;
        }

        return cache[k][n - 1];

//        if (k == 1) {
//            return getResidentsOnZeroFloor(n);
//        }
//        return solve(k + 1, n - 1);
    }

    private static int getResidentsOnZeroFloor(int roomCount) {
        return roomCount * (roomCount + 1) / 2;
    }

}
