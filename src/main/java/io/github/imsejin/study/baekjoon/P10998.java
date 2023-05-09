package io.github.imsejin.study.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class P10998 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();

        StringTokenizer tokenizer = new StringTokenizer(line);

        int a = Integer.parseInt(tokenizer.nextToken());
        int b = Integer.parseInt(tokenizer.nextToken());
        int answer = a * b;

        PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        writer.println(answer);
        writer.close();
    }

}
