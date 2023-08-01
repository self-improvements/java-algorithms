package io.github.imsejin.study.programmers.lv1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/64061">크레인 인형뽑기 게임</a>
 */
public class L64061 {

    static int solve(int[][] board, int[] moves) {
        int count = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int move : moves) {
            int[] row = board[move - 1];
            for (int i = 0; i < row.length; i++) {
                int cell = board[i][move - 1];

                if (cell == 0) continue;

                Integer prev = null;
                if (!stack.isEmpty()) {
                    prev = stack.peekLast();
                }

                stack.offerLast(cell);
                board[i][move - 1] = 0;

                if (Objects.equals(prev, cell)) {
                    stack.pollLast();
                    stack.pollLast();
                    count++;
                }

                break;
            }
        }

        return count * 2;
    }

}
