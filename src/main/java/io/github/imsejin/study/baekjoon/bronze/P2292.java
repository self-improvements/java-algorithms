package io.github.imsejin.study.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2292 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());

            int answer = solve(n);
            System.out.println(answer);
        }
    }

    static int solve(int n) {
        int degree = 1;
        if (n == 1) return degree;

        int startNo = 2;
        while (true) {
            degree++;

            if (startNo <= n && n <= (startNo + 6 * degree - 7)) {
                break;
            }

            startNo += 6 * (degree - 1);
        }

        return degree;
    }

}
