package io.github.imsejin.study.programmers.lv1;

import io.github.imsejin.study.meta.Problem;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/67256">키패드 누르기</a>
 */
@Problem(description = "cell 간 거리 = abs(x1 - x2) + abs(y1 - y2)")
public class L67256 {

    static String solve(int[] numbers, String hand) {
        char[][] keyboard = {
                {'1', '2', '3'},
                {'4', '5', '6'},
                {'7', '8', '9'},
                {'*', '0', '#'},
        };

        Map<Integer, int[]> numberMap = new HashMap<>();
        for (int i = 0; i < keyboard.length; i++) {
            for (int j = 0; j < keyboard[i].length; j++) {
                char key = keyboard[i][j];
                if (!Character.isDigit(key)) continue;

                numberMap.put(Character.getNumericValue(key), new int[]{i, j});
            }
        }

        int[] leftThumb = {3, 0}; // '*'
        int[] rightThumb = {3, 2}; // '#'

        StringBuilder sb = new StringBuilder();

        for (int number : numbers) {
            int[] indexes = numberMap.get(number);

            switch (number) {
                case 1, 4, 7 -> moveThumb(leftThumb, indexes, sb, 'L');
                case 3, 6, 9 -> moveThumb(rightThumb, indexes, sb, 'R');
                default -> {
                    int leftDistance = Math.abs(leftThumb[0] - indexes[0]) + Math.abs(leftThumb[1] - indexes[1]);
                    int rightDistance = Math.abs(rightThumb[0] - indexes[0]) + Math.abs(rightThumb[1] - indexes[1]);

                    if (leftDistance == rightDistance) {
                        if (hand.equals("left")) {
                            moveThumb(leftThumb, indexes, sb, 'L');
                        } else {
                            moveThumb(rightThumb, indexes, sb, 'R');
                        }
                    } else if (leftDistance < rightDistance) {
                        moveThumb(leftThumb, indexes, sb, 'L');
                    } else {
                        moveThumb(rightThumb, indexes, sb, 'R');
                    }
                }
            }
        }

        return sb.toString();
    }

    private static void moveThumb(int[] thumb, int[] indexes, StringBuilder sb, char leftOrRight) {
        thumb[0] = indexes[0];
        thumb[1] = indexes[1];
        sb.append(leftOrRight);
    }

}
