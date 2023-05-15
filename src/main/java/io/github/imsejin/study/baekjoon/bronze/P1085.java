package io.github.imsejin.study.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1085 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int[] numbers = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            // 전제조건: (x,y)는 직사각형 안에 있다.
            int x = numbers[0];
            int y = numbers[1];
            int w = numbers[2];
            int h = numbers[3];

            int distanceX = Math.min(w - x, x);
            int distanceY = Math.min(h - y, y);

            System.out.println(Math.min(distanceX, distanceY));
        }
    }

}
