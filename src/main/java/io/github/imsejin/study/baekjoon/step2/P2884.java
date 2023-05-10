package io.github.imsejin.study.baekjoon.step2;

import java.io.*;
import java.util.StringTokenizer;

public class P2884 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        reader.close();

        int hour = Integer.parseInt(tokenizer.nextToken());
        int minute = Integer.parseInt(tokenizer.nextToken());

        PrintWriter writer =
                new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        if (minute >= 45) {
            writer.printf("%d %d%n", hour, minute - 45);
        } else {
//            writer.printf("%d %d%n", hour == 0 ? 23 : hour - 1, minute + (60 - 45));
            writer.printf("%d %d%n", hour == 0 ? 23 : hour - 1, 60 - Math.abs(minute - 45));
        }

        writer.close();
    }

}
