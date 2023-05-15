package io.github.imsejin.study.programmers;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/120875">평행</a>
 */
public class L120875 {

    public static int solve(int[][] dots) {
        if (calcSlope(dots[0], dots[1]) == calcSlope(dots[2], dots[3])) {
            return 1;
        }
        if (calcSlope(dots[0], dots[2]) == calcSlope(dots[1], dots[3])) {
            return 1;
        }
        if (calcSlope(dots[0], dots[3]) == calcSlope(dots[1], dots[2])) {
            return 1;
        }

        return 0;
    }

    private static double calcSlope(int[] dot1, int[] dot2) {
        return (double) (dot1[1] - dot2[1]) / (dot2[0] - dot1[0]);
    }

}
