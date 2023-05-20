package io.github.imsejin.study.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2839 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int weight = Integer.parseInt(reader.readLine());

            // 5a+3b=w
            int answer = solve1(weight);
            System.out.println(answer);
        }
    }

    static int solve1(int weight) {
        if (weight == 4 || weight == 7) return -1;
        if (weight % 5 == 0) return weight / 5;

        return switch (weight % 5) {
            case 0 -> weight / 5;
            // 1kg를 더 담아야 함 = 5kg 1개 차감, 3kg 2개 증가
            // 3kg를 더 담아야 함 = 3kg 1개 증가
            case 1, 3 -> weight / 5 + 1;
            // 2kg를 더 담아야 함 = 5kg 2개 차감, 3kg 4개 증가
            // 4kg를 더 담아야 함 = 3kg 1개 증가, 1kg의 경우와 같음
            case 2, 4 -> weight / 5 + 2;
            default -> -1;
        };
    }

    static int solve2(int weight) {
        if (weight % 5 == 0) return weight / 5;

        int count5kg = (int) Math.floor(weight / 5.0);
        int count3kg = 1;

        while (count5kg >= 0) {
            while (count5kg * 5 + count3kg * 3 < weight) {
                count3kg++;
            }

            if (count5kg * 5 + count3kg * 3 == weight) return count5kg + count3kg;

            count3kg = 1;
            count5kg--;
        }

        return -1;
    }

}
