package io.github.imsejin.study.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2741 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int number = Integer.parseInt(reader.readLine());
            StringBuilder sb = new StringBuilder();

            for (int i = 1; i <= number; i++) {
                sb.append(i).append('\n');
            }

            System.out.println(sb);
        }
    }

}
