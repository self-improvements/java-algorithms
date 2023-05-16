package io.github.imsejin.study.programmers;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/120812">최빈값 구하기</a>
 */
public class L120812 {

    public static int solve(int[] array) {
        int[] frequencies = new int[1000];
        for (int n : array) {
            frequencies[n]++;
        }

        int max = 0;
        int answer = -1;
        boolean duplicated = false;

        for (int i = 0; i < frequencies.length; i++) {
            if (max < frequencies[i]) {
                max = frequencies[i];
                answer = i;
                duplicated = false;
            } else if (max == frequencies[i]) {
                duplicated = true;
            }
        }

        return duplicated ? -1 : answer;
    }

}
