package io.github.imsejin.study.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1356 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int number = Integer.parseInt(reader.readLine());

            String answer = solve(number);
            System.out.println(answer);
        }
    }

    static String solve(int number) {
        if (number < 10) {
            return "NO";
        }

        int digitCount = getDigitCount(number);
        int loopCount = digitCount - 1;

        for (int i = 0; i < loopCount; i++) {
            // Initialize value with -1. (with zero, it makes result always zero)
            int left = -1;
            int right = -1;

            // Started to right.
            for (int j = 0; j < digitCount; j++) {
                int n = getIntAt(number, j);
                if (j <= i) {
                    right *= n;
                } else {
                    left *= n;
                }
            }

            if (-left == -right) {
                return "YES";
            }
        }

        return "NO";
    }

    static int getIntAt(int number, int i) {
        int remainder = number;

        while (i >= 0) {
            remainder = number % 10;
            number /= 10;
            i--;
        }

        return remainder;
    }

    private static int getDigitCount(int number) {
        return (int) Math.log10(number) + 1;
    }

}
