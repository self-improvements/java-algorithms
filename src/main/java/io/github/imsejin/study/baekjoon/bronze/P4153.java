package io.github.imsejin.study.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P4153 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            while (true) {
                String line = reader.readLine();

                if (line == null || line.equals("0 0 0")) {
                    break;
                }

                int[] sides = Arrays.stream(line.split(" "))
                        .mapToInt(Integer::parseInt).sorted().toArray();
                boolean result = isRightAngledTriangle(sides[0], sides[1], sides[2]);
                sb.append(result ? "right" : "wrong").append('\n');
            }

            System.out.println(sb);
        }
    }

    private static boolean isRightAngledTriangle(int a, int b, int c) {
        return a * a + b * b == c * c;
    }

}
