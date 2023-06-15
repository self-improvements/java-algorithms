package io.github.imsejin.study.baekjoon.silver;

import io.github.imsejin.study.meta.Problem;
import io.github.imsejin.study.meta.Tag;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

@Problem(tags = {
        Tag.DATA_STRUCTURE,
})
public class P4949 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            while (true) {
                String line = reader.readLine();
                if (line == null || line.isEmpty() || line.equals(".")) break;

                boolean answer = solve(line);
                sb.append(answer ? "yes" : "no").append('\n');
            }

            System.out.println(sb);
        }
    }

    static boolean solve(String line) {
        int length = line.length();
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < length; i++) {
            char c = line.charAt(i);

            if (c == '(' || c == '[') {
                stack.offerLast(c);
                continue;
            }

            if (c == ')') {
                // Return fast.
                if (stack.isEmpty()) {
                    return false;
                }

                Character ch = stack.pollLast();
                if (!Objects.equals(ch, '(')) {
                    return false;
                }

                continue;
            }

            if (c == ']') {
                // Return fast.
                if (stack.isEmpty()) {
                    return false;
                }

                Character ch = stack.pollLast();
                if (!Objects.equals(ch, '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

}
