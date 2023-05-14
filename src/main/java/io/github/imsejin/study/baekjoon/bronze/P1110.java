package io.github.imsejin.study.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1110 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int origin = Integer.parseInt(reader.readLine());

            int count = 0;
            int number = origin;
            do {
                int sum = (number / 10) + (number % 10);
                number = (number % 10 * 10) + (sum % 10);
                count++;
            } while (number != origin);

            System.out.println(count);
        }
    }

}
