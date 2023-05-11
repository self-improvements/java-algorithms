package io.github.imsejin.study.baekjoon.step8;

import java.io.*;
import java.util.StringTokenizer;

public class P2745 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        String numeric = tokenizer.nextToken();
        int radix = Integer.parseInt(tokenizer.nextToken());

        reader.close();

        PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        writer.println(Integer.parseInt(numeric, radix));

        writer.close();
    }

}
