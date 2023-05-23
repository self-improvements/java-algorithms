package io.github.imsejin.study.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2869 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int ascent = Integer.parseInt(tokenizer.nextToken());
            int descent = Integer.parseInt(tokenizer.nextToken());
            int height = Integer.parseInt(tokenizer.nextToken());

            int answer = solve(ascent, descent, height);
            System.out.println(answer);
        }
    }

    static int solve(int ascent, int descent, int height) {
        if (ascent >= height) return 1;

        int remain = height - ascent;
        int difference = ascent - descent;

        if (remain % difference == 0) {
            return remain / difference + 1;
        } else if (remain <= difference) {
            return remain / difference + 2;
        } else {
            return remain / difference;
        }
    }

    static int solveSlowly(int ascent, int descent, int height) {
        int day = 1;
        int position = ascent;
        int ascentPerDay = ascent - descent;

        while (position < height) {
            position += ascentPerDay;
            day++;
        }

        return day;
    }

    static int solveVerySlowly(int ascent, int descent, int height) {
        int day = 0;
        int position = 0;

        while (true) {
            day++;
            position += ascent;
            if (position >= height) break;
            position -= descent;
        }

        return day;
    }

}
