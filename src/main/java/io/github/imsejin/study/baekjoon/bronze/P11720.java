package io.github.imsejin.study.baekjoon.bronze;

import java.io.*;
import java.util.Arrays;

public class P11720 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        reader.readLine();
        int sum = Arrays.stream(reader.readLine().split("")).mapToInt(Integer::parseInt).sum();

        reader.close();

        PrintWriter writer =
                new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        writer.println(sum);

        writer.close();
    }

}
