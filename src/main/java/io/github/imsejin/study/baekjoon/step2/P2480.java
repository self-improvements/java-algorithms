package io.github.imsejin.study.baekjoon.step2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P2480 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int a = Integer.parseInt(tokenizer.nextToken());
        int b = Integer.parseInt(tokenizer.nextToken());
        int c = Integer.parseInt(tokenizer.nextToken());

        reader.close();

        PrintWriter writer =
                new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int price;
        if (a == b && b == c) {
            price = 10000 + a * 1000;
        } else if (a == b || b == c || a == c) {
            price = 1000 + (a == b ? a : c) * 100;
        } else {
            price = Math.max(a, Math.max(b, c)) * 100;
        }

        writer.println(price);

        writer.close();
    }

}
