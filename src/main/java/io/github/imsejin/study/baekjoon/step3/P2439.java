package io.github.imsejin.study.baekjoon.step3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class P2439 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))) {
            int count = Integer.parseInt(reader.readLine());

            for (int i = 0; i < count; i++) {
                String stars = "*".repeat(i + 1);
                writer.printf("%" + count + "s%n", stars);
            }
        }
    }

}
