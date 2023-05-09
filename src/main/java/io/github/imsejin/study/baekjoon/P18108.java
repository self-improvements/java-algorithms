package io.github.imsejin.study.baekjoon;

import java.io.*;

public class P18108 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();

        int year = Integer.parseInt(line);
        int converted = year - (2541 - 1998);

        PrintWriter writer =
                new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        writer.println(converted);
        writer.close();
    }

}
