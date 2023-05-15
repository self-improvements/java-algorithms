package io.github.imsejin.study.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P10250 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int count = Integer.parseInt(reader.readLine());

            for (int i = 0; i < count; i++) {
                int[] numbers = Arrays.stream(reader.readLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();
                String answer = solve(numbers[0], numbers[1], numbers[2]);
                System.out.println(answer);
            }
        }
    }

    static String solve(int h, int w, int n) {
        int[] room = new int[2];

        int guestCount = 0;

        outer:
        for (int i = 1; i <= w; i++) {
            room[1] = i;

            for (int j = 1; j <= h; j++) {
                room[0] = j;
                guestCount++;

                if (guestCount == n) {
                    break outer;
                }
            }

            room[0] = 1;
        }

        return String.format("%d%02d", room[0], room[1]);
    }

    static String solve2(int h, int w, int n) {
        int floor = n % h == 0 ? h : n % h;
        double ratio = (double) n / h;
        int room = isInteger(ratio) ? (int) ratio : (int) ratio + 1;

        return String.format("%d%02d", floor, room);
    }

    private static boolean isInteger(double d) {
        return d % 1 == 0;
    }

}
