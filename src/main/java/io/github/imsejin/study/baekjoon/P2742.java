package io.github.imsejin.study.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2742 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int number = Integer.parseInt(reader.readLine());
            StringBuilder sb = new StringBuilder();

            for (int i = number; i > 0; i--) {
                sb.append(i).append('\n');
            }

            System.out.println(sb);
        }
    }

}
