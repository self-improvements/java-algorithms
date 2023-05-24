package io.github.imsejin.study.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1436 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int degree = Integer.parseInt(reader.readLine());

            int answer = solve(degree);
            System.out.println(answer);
        }
    }

    static int solve(int degree) {
        int number = 666;
        int n = 1;

        while (n != degree) {
            number++;
            if (contains666(number)) n++;
        }

        return number;
    }

    private static boolean contains666(int number) {
        int n = 0;

        while (number > 0) {
            if (number % 10 == 6) {
                n++;
            } else {
                n = 0;
            }

            if (n >= 3) return true;

            number /= 10;
        }

        return false;
    }

}
