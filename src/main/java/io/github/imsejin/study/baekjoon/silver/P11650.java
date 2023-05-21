package io.github.imsejin.study.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11650 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Coordinate[] coordinates = new Coordinate[Integer.parseInt(reader.readLine())];
            for (int i = 0; i < coordinates.length; i++) {
                coordinates[i] = Coordinate.from(reader.readLine());
            }

            Arrays.sort(coordinates);

            StringBuilder sb = new StringBuilder();
            for (Coordinate coordinate : coordinates) {
                sb.append(coordinate.x).append(' ').append(coordinate.y).append('\n');
            }

            System.out.println(sb);
        }
    }

    static int solve(int n) {
        int degree = 1;
        if (n == 1) return degree;

        int startNo = 2;
        while (true) {
            degree++;

            if (startNo <= n && n <= (startNo + 6 * degree - 7)) {
                break;
            }

            startNo += 6 * (degree - 1);
        }

        return degree;
    }

    private static class Coordinate implements Comparable<Coordinate> {
        private final int x;
        private final int y;

        private Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public static Coordinate from(String expression) {
            StringTokenizer tokenizer = new StringTokenizer(expression);
            return new Coordinate(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()));
        }

        @Override
        public int compareTo(Coordinate o) {
            int comparison = this.x - o.x;
            return comparison != 0 ? comparison : this.y - o.y;
        }
    }

}
