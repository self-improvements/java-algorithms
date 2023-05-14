package io.github.imsejin.study.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1145 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int[] numbers = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).sorted().toArray();

            int n = numbers[0];
            int count = 0;
            while (true) {
                for (int number : numbers) {
                    if (n % number == 0) {
                        count++;
                    }
                }

                if (count >= 3) {
                    break;
                }

                count = 0;
                n++;
            }

            System.out.println(n);
        }
    }

}
