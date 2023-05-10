package io.github.imsejin.study.baekjoon.step3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class P8393 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int number = Integer.parseInt(reader.readLine());
        int sum = 0;
        for (int i = 1; i <= number; i++) {
            sum += i;
        }

        writer.println(sum);

        reader.close();
        writer.close();
    }

}
