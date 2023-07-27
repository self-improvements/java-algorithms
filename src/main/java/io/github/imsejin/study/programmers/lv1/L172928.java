package io.github.imsejin.study.programmers.lv1;

import java.util.StringTokenizer;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/172928">공원 산책</a>
 */
public class L172928 {

    static int[] solve(String[] park, String[] routes) {
        char[][] board = new char[park.length][];
        for (int i = 0; i < board.length; i++) {
            board[i] = park[i].toCharArray();
        }

        int[] entryPoint = findEntryPoint(board);

        Command[] commands = new Command[routes.length];
        for (int i = 0; i < commands.length; i++) {
            commands[i] = new Command(routes[i]);
        }

        int[] position = entryPoint.clone();
        for (Command command : commands) {
            position = command.move(position, board);
        }

        return position;
    }

    private static int[] findEntryPoint(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'S') return new int[]{i, j};
            }
        }

        throw new AssertionError();
    }

    // -------------------------------------------------------------------------------------------------

    private static class Command {
        private final Direction direction;
        private final int step;

        public Command(String expression) {
            StringTokenizer tokenizer = new StringTokenizer(expression);
            this.direction = Direction.valueOf(tokenizer.nextToken());
            this.step = Integer.parseInt(tokenizer.nextToken());
        }

        public int[] move(int[] pos, char[][] board) {
            int[] tobe = pos;

            for (int i = 0; i < this.step; i++) {
                tobe = this.direction.movePosition(tobe);

                // 주어진 방향으로 이동할 때 공원을 벗어나는지 확인합니다.
                if (tobe[0] < 0 || tobe[0] >= board.length) {
                    return pos;
                }
                if (tobe[1] < 0 || tobe[1] >= board[0].length) {
                    return pos;
                }

                // 주어진 방향으로 이동 중 장애물을 만나는지 확인합니다.
                if (board[tobe[0]][tobe[1]] == 'X') {
                    return pos;
                }
            }

            return tobe;
        }
    }

    private enum Direction {
        E {
            @Override
            public int[] movePosition(int[] pos) {
                pos = pos.clone();
                pos[1]++;
                return pos;
            }
        },

        W {
            @Override
            public int[] movePosition(int[] pos) {
                pos = pos.clone();
                pos[1]--;
                return pos;
            }
        },

        S {
            @Override
            public int[] movePosition(int[] pos) {
                pos = pos.clone();
                pos[0]++;
                return pos;
            }
        },

        N {
            @Override
            public int[] movePosition(int[] pos) {
                pos = pos.clone();
                pos[0]--;
                return pos;
            }
        };

        public abstract int[] movePosition(int[] pos);
    }

}
