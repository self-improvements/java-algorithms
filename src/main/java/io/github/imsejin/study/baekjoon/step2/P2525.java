package io.github.imsejin.study.baekjoon.step2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P2525 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int hour = Integer.parseInt(tokenizer.nextToken());
        int minute = Integer.parseInt(tokenizer.nextToken());
        int cookingMin = Integer.parseInt(reader.readLine());
        int cookingHour = cookingMin / 60;
        cookingMin = cookingMin % 60;
        reader.close();

        PrintWriter writer =
                new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        if (cookingHour > 0) {
            hour += cookingHour;
        }

        if (minute + cookingMin < 60) {
            minute += cookingMin;
        } else {
            hour += (minute + cookingMin) / 60;
            minute = (minute + cookingMin) % 60;
        }

        if (hour >= 24) {
            hour %= 24;
        }

        writer.printf("%d %d%n", hour, minute);

        writer.close();
    }

}
