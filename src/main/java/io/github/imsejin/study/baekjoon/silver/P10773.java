package io.github.imsejin.study.baekjoon.silver;

import io.github.imsejin.study.meta.Problem;
import io.github.imsejin.study.meta.Tag;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

@Problem(tags = {
        Tag.DATA_STRUCTURE,
})
public class P10773 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int[] numbers = new int[Integer.parseInt(reader.readLine())];

            for (int i = 0; i < numbers.length; i++) {
                int number = Integer.parseInt(reader.readLine());
                numbers[i] = number;
            }

            int answer = solve(numbers);
            System.out.println(answer);
        }
    }

    static int solve(int[] numbers) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int number : numbers) {
            if (number == 0) {
                stack.pop();
            } else {
                stack.push(number);
            }
        }

        return stack.stream().mapToInt(n -> n).sum();
    }

}
