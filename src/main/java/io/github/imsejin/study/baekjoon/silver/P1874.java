package io.github.imsejin.study.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class P1874 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int[] sequence = new int[Integer.parseInt(reader.readLine())];
            for (int i = 0; i < sequence.length; i++) {
                int number = Integer.parseInt(reader.readLine());
                sequence[i] = number;
            }

            StringBuilder sb = new StringBuilder();
            String[] answer = solve(sequence);
            sb.append(answer).append('\n');

            System.out.println(sb);
        }
    }

    static String[] solve(int[] sequence) {
        Deque<Integer> stack = new ArrayDeque<>();
        List<String> results = new ArrayList<>(sequence.length);

        int i = 1;
        while (i < 1000) {
            int n = sequence[i - 1];
            if (i == n) {
                stack.pollLast();
                results.add("-");

            } else {
                stack.offerLast(i);
                results.add("+");
                i++;
            }
        }

        return results.toArray(new String[0]);
    }

}
