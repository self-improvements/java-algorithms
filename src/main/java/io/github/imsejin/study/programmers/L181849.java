package io.github.imsejin.study.programmers;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/181849">문자열 정수의 합</a>
 */
public class L181849 {

    public static int solve(String s) {
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int number = c - '0';

            sum += number;
        }

        return sum;
    }

}
