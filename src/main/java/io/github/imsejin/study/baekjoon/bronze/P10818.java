package io.github.imsejin.study.baekjoon.bronze;

import java.io.*;
import java.util.StringTokenizer;

public class P10818 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(reader.readLine());
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < count; i++) {
            int number = Integer.parseInt(tokenizer.nextToken());
            min = Math.min(min, number);
            max = Math.max(max, number);
        }

        reader.close();

        PrintWriter writer =
                new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        writer.printf("%d %d%n", min, max);

        writer.close();
    }

}
