package io.github.imsejin.study.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1016 {

    private static final char WHITE = 'W';

    private static final char BLACK = 'B';

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int rowCount = Integer.parseInt(tokenizer.nextToken());
            int columnCount = Integer.parseInt(tokenizer.nextToken());

            char[][] board = new char[rowCount][columnCount];
            for (int i = 0; i < board.length; i++) {
                board[i] = reader.readLine().toCharArray();
            }

            int answer = solve(board);
            System.out.println(answer);
        }
    }

    static int solve(char[][] board) {
        int fixCount = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (isOdd(i+1)) {
                    // 홀수 행: WBWBWBWB
                    char color = isOdd(j + 1) ? WHITE : BLACK;
                    if (board[i][j] != color) ;
                } else {
                    // 짝수 행: BWBWBWBW

                }
                if (board[i][j] != WHITE) ;
            }

//            for (int j = 0; j < board[i].length - 7; j++) {
//                if (board[i][j] != WHITE)
//                if (board[i][j + 1] != BLACK)
//                if (board[i][j + 2] != WHITE)
//                if (board[i][j + 3] != BLACK)
//                if (board[i][j + 4] != WHITE)
//                if (board[i][j + 5] != BLACK)
//                if (board[i][j + 6] != WHITE)
//                if (board[i][j + 7] != BLACK)
//            }

        }

        return fixCount;
    }

    private static boolean isOdd(int number) {
        return (number & 1) == 1;
    }

}
