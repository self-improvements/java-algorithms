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

            // board[rowCount-1][columnCount-1]를 커버하기 위해서 체스판을 뒤집어서 한 번 더 검사한다.
            char[][] reversedBoard = new char[board.length][board[0].length];
            for (int i = board.length - 1; i >= 0; i--) {
                for (int j = board[i].length - 1; j >= 0; j--) {
                    reversedBoard[-(i - board.length + 1)][-(j - board[i].length + 1)] = board[i][j];
                }
            }

            int answer = solve(board);
            answer = Math.min(answer, solve(reversedBoard));

            System.out.println(answer);
        }
    }

    static int solve(char[][] board) {
        int min = Integer.MAX_VALUE;
        Context ctx = new Context(board);

        int rowLoopCount = (board.length % 8) + 1;
        int columnLoopCount = (board[0].length % 8) + 1;

        for (int i = 0; i < rowLoopCount; i++) {
            for (int j = 0; j < columnLoopCount; j++) {
                ctx.rowCursor = i;
                ctx.columnCursor = j;
                ctx.rootCellColor = board[i][j];

                int illegalCellCount = getIllegalCountOnSquare(ctx);
                min = Math.min(min, illegalCellCount);
            }
        }

        return min;
    }

    private static int getIllegalCountOnSquare(Context ctx) {
        int illegalCellCount = 0;

        for (int i = ctx.rowCursor; i < ctx.rowCursor + 8; i++) {
            ctx.rowIndex = i;
            ctx.row = ctx.board[i];

            int count = getIllegalCellCountOnRow(ctx);
            illegalCellCount += count;
        }

        return illegalCellCount;
    }

    private static int getIllegalCellCountOnRow(Context ctx) {
        int illegalCellCount = 0;

        for (int i = ctx.columnCursor; i < ctx.columnCursor + 8; i++) {
            char color = ctx.getCorrectColor(i);
            if (ctx.row[i] != color) illegalCellCount++;
        }

        return illegalCellCount;
    }

    private static boolean isOdd(int number) {
        return (number & 1) == 1;
    }

    private static class Context {
        private final char[][] board;

        private char[] row;
        private int rowIndex;

        private char rootCellColor;
        private int rowCursor;
        private int columnCursor;

        private Context(char[][] board) {
            this.board = board;
        }

        public char getCorrectColor(int columnIndex) {
            if (isOdd(rowCursor) == isOdd(rowIndex) && isOdd(columnCursor) == isOdd(columnIndex)) {
                // 가로/세로
                return rootCellColor;
            } else if (isOdd(rowCursor) != isOdd(rowIndex) && isOdd(columnCursor) != isOdd(columnIndex)) {
                // 대각선
                return rootCellColor;
            } else {
                return rootCellColor == WHITE ? BLACK : WHITE;
            }
        }
    }

}
