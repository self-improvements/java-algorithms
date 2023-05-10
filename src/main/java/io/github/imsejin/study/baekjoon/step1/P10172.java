package io.github.imsejin.study.baekjoon.step1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class P10172 {

    public static void main(String[] args) throws IOException {
        PrintWriter writer =
                new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        writer.println("""
                |\\_/|
                |q p|   /}
                ( 0 )""\"\\
                |"^"`    |
                ||_/=\\\\__|
                """);
        writer.close();
    }

}
