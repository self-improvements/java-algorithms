package io.github.imsejin.study.programmers;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/181932">코드 처리하기</a>
 */
public class L181932 {

    public static String solve(String code) {
        Mode mode = Mode.EVEN;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < code.length(); i++) {
            char c = code.charAt(i);

            if (c == '1') {
                mode = mode.toggle();
                continue;
            }

            if (!mode.canHandle(c, i)) {
                continue;
            }

            sb.append(c);
        }

        return sb.length() == 0 ? "EMPTY" : sb.toString();
    }

    private enum Mode {
        ODD {
            @Override
            public boolean canHandle(char c, int i) {
                return c != '1' && (i & 1) == 1;
            }

            @Override
            public Mode toggle() {
                return EVEN;
            }
        },

        EVEN {
            @Override
            public boolean canHandle(char c, int i) {
                return c != '1' && (i & 1) == 0;
            }

            @Override
            public Mode toggle() {
                return ODD;
            }
        };

        public abstract boolean canHandle(char c, int i);
        public abstract Mode toggle();
    }

}
