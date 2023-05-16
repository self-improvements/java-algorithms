package io.github.imsejin.study.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1268 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int studentCount = Integer.parseInt(reader.readLine());
            int[][] table = new int[studentCount][];

            for (int i = 0; i < studentCount; i++) {
                int[] row = Arrays.stream(reader.readLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();
                table[i] = row;
            }

            int studentNo = solve(table);
            System.out.println(studentNo);
        }
    }

    static int solve(int[][] table) {
        // Each index is a student number.
        int[] counts = new int[table.length];

        for (int i = 0; i < table.length; i++) {
            int[] baseStudent = table[i];

            for (int j = 0; j < table.length; j++) {
                if (i == j) continue;

                int[] targetStudent = table[j];
//                int count = countMatching(baseStudent, targetStudent);
//                counts[i] += count;
                if (anyMatches(baseStudent, targetStudent)) {
                    counts[i]++;
                }
            }
        }

        int studentNo = 1;
        int max = 0;
        for (int i = 0; i < counts.length; i++) {
            if (max < counts[i]) {
                max = counts[i];
                studentNo = i + 1;
            }
        }

        return studentNo;
    }

    private static boolean anyMatches(int[] base, int[] target) {
        int len = Math.min(base.length, target.length);

        for (int i = 0; i < len; i++) {
            if (base[i] == target[i]) return true;
        }

        return false;
    }

    // Misunderstanding the problem.
    private static int countMatching(int[] base, int[] target) {
        int len = Math.min(base.length, target.length);

        int count = 0;
        for (int i = 0; i < len; i++) {
            if (base[i] == target[i]) count++;
        }

        return count;
    }

}
