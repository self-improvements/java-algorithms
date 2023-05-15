package io.github.imsejin.study.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2231 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            int answer = solve(n);

            System.out.println(answer);
        }
    }

    static int solve(int n) {
        // 분해합에서 각 자리수의 합의 최대값은 9의 배수.
        // n=1026 ... 999+(9+9+9)
        // n=256 ... 245+(2+4+5)
        // n=50 ... 43+(4+3)
        // n=50 ... 43+(4+3)
        int start = Math.max(0, getDigitCount(n));

        for (int i = start; i < n; i++) {
            int sum = generate(i);
            if (sum == n) return i;
        }

        return 0;
    }

    private static int generate(int n) {
        int sum = n;

        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }

    private static int getDigitCount(int n) {
        return (int) Math.log10(n) + 1;
    }

}
