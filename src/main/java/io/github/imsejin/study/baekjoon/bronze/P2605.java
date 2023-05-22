package io.github.imsejin.study.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P2605 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            reader.readLine();

            int[] picks = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            List<Integer> students = new ArrayList<>();
            for (int i = 0; i < picks.length; i++) {
                students.add(picks[i], i + 1);
            }

            StringBuilder sb = new StringBuilder();
            for (int i = students.size() - 1; i >= 0; i--) {
                sb.append(students.get(i)).append(' ');
            }

            System.out.println(sb);
        }
    }

}
