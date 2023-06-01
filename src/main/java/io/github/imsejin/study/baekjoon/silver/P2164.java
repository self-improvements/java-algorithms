package io.github.imsejin.study.baekjoon.silver;

import io.github.imsejin.study.meta.Problem;
import io.github.imsejin.study.meta.Tag;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;

@Problem(tags = {
        Tag.DATA_STRUCTURE,
})
public class P2164 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int count = Integer.parseInt(reader.readLine());
            int answer = solve(count);
            System.out.println(answer);
        }
    }

    static int solve(int count) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= count; i++) {
            queue.offer(i);
        }

        while (queue.size() > 1) {
            // 우선, 제일 위에 있는 카드를 바닥에 버린다.
            queue.poll();

            // 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮긴다.
            Integer number = queue.poll();
            queue.offer(number);
        }

        return Objects.requireNonNull(queue.peek());
    }

}
