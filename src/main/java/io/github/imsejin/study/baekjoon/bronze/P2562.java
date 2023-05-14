package io.github.imsejin.study.baekjoon.bronze;

import java.io.*;

public class P2562 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int max = 0;
        int index = 0;

        for (int i = 0; i < 9; i++) {
            int number = Integer.parseInt(reader.readLine());
            int compared = Math.max(max, number);
            if (max < compared) {
                max = compared;
                index = i;
            }
        }

        reader.close();

        PrintWriter writer =
                new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        writer.printf("%d%n%d%n", max, index + 1);

        writer.close();
    }

}
