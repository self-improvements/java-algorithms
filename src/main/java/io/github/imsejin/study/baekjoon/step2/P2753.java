package io.github.imsejin.study.baekjoon.step2;

import java.io.*;
import java.util.StringTokenizer;

public class P2753 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        reader.close();

        int year = Integer.parseInt(tokenizer.nextToken());

        PrintWriter writer =
                new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int result = (year % 4 == 0) && (year % 100 != 0 || year % 400 == 0) ? 1 : 0;

        writer.println(result);
        writer.close();
    }

}
