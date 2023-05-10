package io.github.imsejin.study.baekjoon.step2;

import java.io.*;
import java.util.StringTokenizer;

public class P1330 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        reader.close();

        int a = Integer.parseInt(tokenizer.nextToken());
        int b = Integer.parseInt(tokenizer.nextToken());


        PrintWriter writer =
                new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        String result;
        if (a > b) {
            result = ">";
        } else if (a < b) {
            result = "<";
        } else {
            result = "==";
        }

        writer.println(result);
        writer.close();
    }

}
