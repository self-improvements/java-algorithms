package io.github.imsejin.study.baekjoon.step1;

import java.io.*;
import java.util.StringTokenizer;

public class P10926 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String userid = reader.readLine();

        PrintWriter writer =
                new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        writer.println(userid + "??!");
        writer.close();
    }

}
