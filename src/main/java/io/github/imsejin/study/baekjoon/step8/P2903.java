package io.github.imsejin.study.baekjoon.step8;

import java.io.*;

public class P2903 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer =
                new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int count = Integer.parseInt(reader.readLine());
        int width = (int) Math.pow(2, count);
        int pointCount = (int) Math.pow(width + 1, 2);

        writer.println(pointCount);

        reader.close();
        writer.close();
    }

}
