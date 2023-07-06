package io.github.imsejin.study.programmers;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/181931">등차수열의 특정한 항만 더하기</a>
 */
public class L181931 {

    static int solve(int a, int d, boolean[] included) {
        int sum = 0;

        for (int i = 0; i < included.length; i++) {
            if (!included[i]) {
                continue;
            }

            // a[n] == a + (n - 1) * d
            int element = a + (i * d);
            sum += element;
        }

        return sum;
    }

}
