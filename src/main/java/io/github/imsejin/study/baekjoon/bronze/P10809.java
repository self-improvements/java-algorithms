package io.github.imsejin.study.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;

public class P10809 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))) {
            int[] indexes = new int[26];
            Arrays.fill(indexes, -1);

            String word = reader.readLine();

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (indexes[c - 'a'] == -1) {
                    indexes[c - 'a'] = i;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int index : indexes) {
                sb.append(index).append(' ');
            }
            sb.deleteCharAt(sb.length() - 1);

            writer.println(sb);
        }
    }

}
