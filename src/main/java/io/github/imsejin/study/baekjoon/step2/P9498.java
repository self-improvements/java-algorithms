package io.github.imsejin.study.baekjoon.step2;

import java.io.*;
import java.util.StringTokenizer;

public class P9498 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        reader.close();

        int score = Integer.parseInt(tokenizer.nextToken());

        PrintWriter writer =
                new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        char result;
        if (score >= 90) {
            result = 'A';
        } else if (score >= 80) {
            result = 'B';
        } else if (score >= 70) {
            result = 'C';
        } else if (score >= 60) {
            result = 'D';
        } else {
            result = 'F';
        }

        writer.println(result);
        writer.close();
    }

}
