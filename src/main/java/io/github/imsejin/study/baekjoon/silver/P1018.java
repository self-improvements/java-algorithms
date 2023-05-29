package io.github.imsejin.study.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1018 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int rowCount = Integer.parseInt(tokenizer.nextToken());
            int columnCount = Integer.parseInt(tokenizer.nextToken());

            char[][] board = new char[rowCount][columnCount];
            for (int i = 0; i < board.length; i++) {
                board[i] = reader.readLine().toCharArray();
            }

            int answer = OddEven.solve(board);

            System.out.println(answer);
        }
    }

    // ----------------------------------------------------------------------------------------------------

    public static class Line {

        private static final int WINDOW_SIZE = 8;
        private static final char[] WHITE_FIRST_LINE = "WB".repeat(WINDOW_SIZE / 2).toCharArray();
        private static final char[] BLACK_FIRST_LINE = "BW".repeat(WINDOW_SIZE / 2).toCharArray();

        static int solve(char[][] board) {
            Context ctx = new Context(board);

            int rowLoopCount = (board.length - WINDOW_SIZE) + 1;
            int columnLoopCount = (board[0].length - WINDOW_SIZE) + 1;

            int[] counts = {Integer.MAX_VALUE, Integer.MAX_VALUE};

            for (int i = 0; i < rowLoopCount; i++) {
                ctx.rowCursor = i;

                for (int j = 0; j < columnLoopCount; j++) {
                    ctx.columnCursor = j;
                    int[] countsOnWindow = getUnmatchedCellCountOnWindow(ctx);
                    counts[0] = Math.min(counts[0], countsOnWindow[0]);
                    counts[1] = Math.min(counts[1], countsOnWindow[1]);
                }
            }

            return Math.min(counts[0], counts[1]);
        }

        private static int[] getUnmatchedCellCountOnWindow(Context ctx) {
            int[] counts = new int[2];

            int rowCursorEnd = ctx.rowCursor + WINDOW_SIZE;
            for (int i = ctx.rowCursor; i < rowCursorEnd; i++) {
                ctx.rowIndexOnWindow = i;

                int[] countsOnRow = getUnmatchedCellCountOnRow(ctx);
                counts[0] += countsOnRow[0];
                counts[1] += countsOnRow[1];
            }

            return counts;
        }

        private static int[] getUnmatchedCellCountOnRow(Context ctx) {
            // 백으로 시작하는 경우, 흑으로 시작하는 경우를 저장한다.
            int[] counts = new int[2];

            // 매 행마다 백/흑 라인이 번갈아 발생한다.
            boolean odd = (ctx.rowIndexOnWindow & 1) == 1;

            int columnCursorEnd = ctx.columnCursor + WINDOW_SIZE;
            for (int i = ctx.columnCursor; i < columnCursorEnd; i++) {
                char[] row = ctx.board[ctx.rowIndexOnWindow];
                char cell = row[i];

                if (WHITE_FIRST_LINE[i - ctx.columnCursor] != cell) counts[odd ? 0 : 1]++;
                if (BLACK_FIRST_LINE[i - ctx.columnCursor] != cell) counts[odd ? 1 : 0]++;
            }

            return counts;
        }

        private static class Context {
            private final char[][] board;

            private int rowIndexOnWindow;
            private int rowCursor;
            private int columnCursor;

            private Context(char[][] board) {
                this.board = board;
            }
        }

    }

    // ----------------------------------------------------------------------------------------------------

    public static class OddEven {

        private static final char WHITE = 'W';

        private static final char BLACK = 'B';

        static int solve(char[][] board) {
            // board[rowCount-1][columnCount-1]를 커버하기 위해서 체스판을 뒤집어서 한 번 더 검사한다.
            char[][] reversedBoard = new char[board.length][board[0].length];
            for (int i = board.length - 1; i >= 0; i--) {
                for (int j = board[i].length - 1; j >= 0; j--) {
                    reversedBoard[-(i - board.length + 1)][-(j - board[i].length + 1)] = board[i][j];
                }
            }

            int answer = calculate(board);
            answer = Math.min(answer, calculate(reversedBoard));

            return answer;
        }

        private static int calculate(char[][] board) {
            int min = Integer.MAX_VALUE;
            Context ctx = new Context(board);

            int rowLoopCount = (board.length - 8) + 1;
            int columnLoopCount = (board[0].length - 8) + 1;

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


}
