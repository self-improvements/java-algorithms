package io.github.imsejin.study.baekjoon.step3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class P2739 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int number = Character.digit(reader.readLine().charAt(0), 10);

        reader.close();

        PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        for (int i = 1; i <= 9; i++) {
            writer.printf("%d * %d = %d%n", number, i, number * i);
        }

        writer.close();
    }

}
