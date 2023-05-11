package io.github.imsejin.study.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;

public class P2475 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))) {
            int sum = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(n -> (int) Math.pow(Integer.parseInt(n), 2)).sum();
            int checkDigit = sum % 10;

            writer.println(checkDigit);
        }
    }

}
