package io.github.imsejin.study.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2908 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());

            int reversedA = reverse(a);
            int reversedB = reverse(b);

            System.out.println(Math.max(reversedA, reversedB));
        }
    }

    private static int reverse(int number) {
        if (getDigitCount(number) != 3) {
            throw new AssertionError();
        }

        int reversed = 0;

        while (number != 0) {
            reversed += number % 10;
            number /= 10;
            if (number != 0) reversed *= 10;
        }

        return reversed;
    }

    private static int getDigitCount(int number) {
        return (int) Math.log10(number) + 1;
    }

}
