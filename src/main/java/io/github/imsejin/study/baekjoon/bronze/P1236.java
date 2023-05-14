package io.github.imsejin.study.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1236 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int y = Integer.parseInt(tokenizer.nextToken());
            int x = Integer.parseInt(tokenizer.nextToken());

            char[][] castle = new char[y][x];

            for (int i = 0; i < castle.length; i++) {
                String line = reader.readLine();
                castle[i] = line.toCharArray();
            }

            int answer = solve(castle);
            System.out.println(answer);
        }
    }

    private static int solve(char[][] castle) {
        int lackRowCount = 0;
        int lackColumnCount = 0;

        // Find guard each row.
        for (char[] row : castle) {
            int guardCountPerRow = 0;

            for (char cell : row) {
                if (cell == 'X') guardCountPerRow++;
            }

            if (guardCountPerRow == 0) lackRowCount++;
        }

        // Find guard each column.
        int columnCount = castle[0].length;
        for (int i = 0; i < columnCount; i++) {
            int guardCountPerColumn = 0;

            for (char[] row : castle) {
                char cell = row[i];
                if (cell == 'X') guardCountPerColumn++;
            }

            if (guardCountPerColumn == 0) lackColumnCount++;
        }

        return Math.max(lackRowCount, lackColumnCount);
    }

}
