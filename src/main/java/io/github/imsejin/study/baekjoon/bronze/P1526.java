package io.github.imsejin.study.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1526 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int number = Integer.parseInt(reader.readLine());

            int answer = solve(number);
            System.out.println(answer);
        }
    }

    static int solve(int number) {
        for (int i = number; i >= 0; i--) {
            if (hasOnlyFourOrSeven(i)) {
                return i;
            }
        }

        throw new AssertionError();
    }

    private static boolean hasOnlyFourOrSeven(int number) {
        while (number > 0) {
            int digit = number % 10;
            if (digit != 4 && digit != 7) return false;
            number /= 10;
        }

        return true;
    }

}
