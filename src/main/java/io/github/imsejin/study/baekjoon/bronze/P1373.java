package io.github.imsejin.study.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class P1373 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String binary = reader.readLine();

            String answer = solve1(binary);
            System.out.println(answer);
        }
    }

    static String solve1(String binary) {
        if (binary.equals("0")) return "0";

        int length = binary.length();
        StringBuilder sb = new StringBuilder();

        int bit = 0;
        for (int i = 1; i <= length; i++) {
            char c = binary.charAt(length - i);

            int r = i % 3;
            if (c == '1') {
                int b = switch (r) {
                    case 1 -> 1;
                    case 2 -> 2;
                    case 0 -> 4;
                    default -> throw new IllegalArgumentException();
                };

                bit += b;
            }

            if (r == 0) {
                sb.append(bit);
                bit = 0;
            }
        }

        if (bit > 0) sb.append(bit);

        return sb.reverse().toString();
    }

    static String solve2(String binary) {
        return new BigInteger(binary, 2).toString(8);
    }

}
