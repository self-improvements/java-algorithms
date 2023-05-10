package io.github.imsejin.study.baekjoon.step1;

import java.io.*;
import java.util.StringTokenizer;

public class P11382 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();

        StringTokenizer tokenizer = new StringTokenizer(line);

        long a = Long.parseLong(tokenizer.nextToken());
        long b = Long.parseLong(tokenizer.nextToken());
        long c = Long.parseLong(tokenizer.nextToken());
        reader.close();

        PrintWriter writer =
                new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        writer.println(a + b + c);
        writer.close();
    }

}
