package io.github.imsejin.study.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P1081 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());

            long answer = 0;
            for (int i = 0; i < b - a + 1; i++) {
                long number = i + a;
                long sum = sumDigits(number);
                answer += sum;
            }

            writer.println(answer);
        }
    }

    private static int getDigitCount(long number) {
        return (int) (Math.log10(number) + 1);
    }

    private static int sumDigits(long number) {
        if (number == 0) return 0;

        int sum = 0;
        int digitCount = getDigitCount(number);

        for (int i = 0; i < digitCount; i++) {
            int digit = (int) ((number / (int) Math.pow(10, i)) % 10);
            sum += digit;
        }

        return sum;
    }

}
