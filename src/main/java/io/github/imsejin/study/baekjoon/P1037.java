package io.github.imsejin.study.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1037 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            reader.readLine();

            long[] numbers = Arrays.stream(reader.readLine().split(" "))
                    .mapToLong(Long::parseLong).sorted().toArray();

            long answer;
            if (numbers.length == 1) {
                answer = numbers[0] * numbers[0];
            } else {
                answer = numbers[0] * numbers[numbers.length - 1];
            }

            System.out.println(answer);
        }
    }

}
