package io.github.imsejin.study.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class P2558 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        reader.close();

        PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        writer.println(a * getIntAt(b, 1));
        writer.println(a * getIntAt(b, 2));
        writer.println(a * getIntAt(b, 3));
        writer.println(a * b);
        writer.close();
    }

    private static int getIntAt(int number, int digit) {
        return number % (int) Math.pow(10, digit) / (int) Math.pow(10, digit - 1);
    }

}
