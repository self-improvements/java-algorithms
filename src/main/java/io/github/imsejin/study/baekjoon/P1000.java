package io.github.imsejin.study.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P1000 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();

        int answer = 0;
        StringTokenizer tokenizer = new StringTokenizer(line);

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            int number = Integer.parseInt(token);
            answer += number;
        }

        PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        writer.println(answer);
        writer.close();
    }

}
