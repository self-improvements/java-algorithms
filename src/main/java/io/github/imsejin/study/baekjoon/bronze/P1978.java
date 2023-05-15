package io.github.imsejin.study.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1978 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            reader.readLine();

            int[] numbers = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            int count = 0;
            for (int number : numbers) {
                if (isPrime(number)) count++;
            }

            System.out.println(count);
        }
    }

    static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;

        if ((n & 1) == 0) return false;

        for (int i = 3; i < n; i += 2) {
            if (n % i == 0) return false;
        }

        return true;
    }

}
