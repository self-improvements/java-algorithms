package io.github.imsejin.study.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2609 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());

            System.out.printf("%d%n%d", gcd(a, b), lcm(a, b));
        }
    }

    static int gcd(int a, int b) {
        // GCD(a,b) = GCD(b,a%b)
        while (true) {
            if (a % b == 0) {
                return b;
            }

            int temp = a;
            a = b;
            b = temp % b;
        }
    }

    static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

}
