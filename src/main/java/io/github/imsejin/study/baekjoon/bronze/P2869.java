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

        // An = A + (n-1)d ... 등차수열

        // 마지막 날에 ascent만큼 오르고 내려가지 않는다.
        // ascent < height 경우 마지막 날에 ascent만큼 올라가야 하는 게 확정이니
        // 마지막 날에 올라갈 길이를 뺀 나머지 길이를 대상으로 계산한다.
        int remain = height - ascent;
        int difference = ascent - descent;

        if (remain % difference == 0) {
            // 나누어 떨어지면, 마지막 날만 더하고 끝.
            return remain / difference + 1;
        } else {
            // 나누어 떨어지지 않으면, 추가 하루 + 마지막 날을 더하고 끝.
            return remain / difference + 2;
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
