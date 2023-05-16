package io.github.imsejin.study.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11050 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(tokenizer.nextToken());
            int r = Integer.parseInt(tokenizer.nextToken());

            System.out.println(combination(n, r));
        }
    }

    static int combination(int n, int r) {
        // nCr = n!/r!(n-r)!
        return factorial(n) / (factorial(n - r) * factorial(r));
    }

    static int factorial(int n) {
        int result = 1;
        while (n >= 2) {
            result *= n--;
        }

        return result;
    }

    static int _factorial(int n) {
        if (n < 2) return 1;
        return n * _factorial(n - 1);
    }

}
