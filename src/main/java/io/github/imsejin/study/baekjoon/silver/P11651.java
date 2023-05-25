package io.github.imsejin.study.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.util.Comparator.comparing;

public class P11651 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int count = Integer.parseInt(reader.readLine());

            Coordinate[] coordinates = new Coordinate[count];
            for (int i = 0; i < count; i++) {
                coordinates[i] = Coordinate.from(reader.readLine());
            }

            Arrays.sort(coordinates, comparing(Coordinate::getY).thenComparing(Coordinate::getX));

            StringBuilder sb = new StringBuilder();
            for (Coordinate coordinate : coordinates) {
                sb.append(coordinate.x).append(' ').append(coordinate.y).append('\n');
            }

            System.out.println(sb);
        }
    }

    private static class Coordinate {
        private final int x;
        private final int y;

        private Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public static Coordinate from(String expression) {
            StringTokenizer tokenizer = new StringTokenizer(expression);
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());

            return new Coordinate(x, y);
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

}
