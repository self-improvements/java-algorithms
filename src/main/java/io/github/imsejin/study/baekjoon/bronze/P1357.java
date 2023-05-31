package io.github.imsejin.study.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1357 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());

            int answer = solve(x, y);
            System.out.println(answer);
        }
    }

    static int solve(int x, int y) {
        return reverse(reverse(x) + reverse(y));
    }

    static int reverse(int number) {
        int reversed = 0;

        while (number > 0) {
            reversed *= 10;
            reversed += number % 10;
            number /= 10;
        }

        return reversed;
    }

}
