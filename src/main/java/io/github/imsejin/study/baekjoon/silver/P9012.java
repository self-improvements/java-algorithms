package io.github.imsejin.study.baekjoon.silver;

import io.github.imsejin.study.meta.Problem;
import io.github.imsejin.study.meta.Tag;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

@Problem(tags = {
        Tag.DATA_STRUCTURE,
})
public class P9012 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            reader.readLine();

            StringBuilder sb = new StringBuilder();
            while (true) {
                String ps = reader.readLine();
                if (ps == null || ps.isEmpty()) break;

                String answer = solve(ps) ? "YES" : "NO";
                sb.append(answer).append('\n');
            }

            System.out.println(sb);
        }
    }

    static boolean solve(String ps) {
        Deque<Character> stack = new ArrayDeque<>();

        try {
            int length = ps.length();
            for (int i = 0; i < length; i++) {
                char c = ps.charAt(i);

                switch (c) {
                    case '(' -> stack.push(c);
                    case ')' -> stack.pop();
                    default -> throw new AssertionError();
                }
            }
        } catch (NoSuchElementException ignored) {
            return false;
        }

        return stack.isEmpty();
    }

}
