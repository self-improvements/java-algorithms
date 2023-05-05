package io.github.imsejin.study.programmers;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/181848">문자열을 정수로 변환하기</a>
 */
public class L181848 {

    public static int solve(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("s is null or empty: " + s);
        }

        return parseInt(s);
    }

    private static int parseInt(String s) {
        boolean negative = s.charAt(0) == '-';

        int result = 0;
        for (int i = negative ? 1 : 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int number = c - '0';

            if (number < 0 || number > 9) {
                throw new NumberFormatException("Parsing illegal number: " + s);
            }

            result *= 10;
            result += number;
        }

        return negative ? -result : result;
    }

}
