package io.github.imsejin.study.baekjoon.step3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P25304 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int total = Integer.parseInt(reader.readLine());
        int goodsTypeCount = Integer.parseInt(reader.readLine());

        int sum = 0;
        for (int i = 0; i < goodsTypeCount; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int price = Integer.parseInt(tokenizer.nextToken());
            int count = Integer.parseInt(tokenizer.nextToken());

            sum += price * count;
        }

        writer.println(total == sum ? "Yes" : "No");

        reader.close();
        writer.close();
    }

}
