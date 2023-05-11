package io.github.imsejin.study.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class P2577 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))) {
            int a = Integer.parseInt(reader.readLine());
            int b = Integer.parseInt(reader.readLine());
            int c = Integer.parseInt(reader.readLine());

            int[] counts = new int[10];
            int number = a * b * c;

            while (number > 0) {
                int digit = number % 10;
                counts[digit]++;
                number /= 10;
            }

            for (int count : counts) {
                writer.println(count);
            }
        }
    }

}
