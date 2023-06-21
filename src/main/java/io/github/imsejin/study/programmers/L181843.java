package io.github.imsejin.study.programmers;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/181843">부분 문자열인지 확인하기</a>
 */
public class L181843 {

    static int solve(String myString, String target) {
        if (target.isEmpty()) {
            return 1;
        }

        if (myString.length() < target.length()) {
            return 0;
        }

        Queue<Character> queue = new ArrayDeque<>();
        for (char c : myString.toCharArray()) {
            queue.add(c);
        }

        int i = 0;
        int matched = 0;

        while (!queue.isEmpty()) {
            Character c = queue.poll();

            if (i == target.length()) {
                break;
            }

            char targetChar = target.charAt(i);
            if (c == targetChar) {
                matched++;
                i++;
            } else {
                matched = 0;
            }
        }

        if (matched == target.length()) {
            return 1;
        }

        return 0;
    }

}
