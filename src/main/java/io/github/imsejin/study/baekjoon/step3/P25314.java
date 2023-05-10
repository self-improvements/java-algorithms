package io.github.imsejin.study.baekjoon.step3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class P25314 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int bytes = Integer.parseInt(reader.readLine());
        writer.print("long ".repeat(bytes / 4));
        writer.println("int");

        reader.close();
        writer.close();
    }

}
