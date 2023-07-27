package io.github.imsejin.study.programmers;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/155652">둘만의 암호</a>
 */
public class L155652 {

    static String solve(String s, String skip, int index) {
        int[] skipArray = new int['z' - 'a' + 1];
        for (int i = 0; i < skip.length(); i++) {
            char c = skip.charAt(i);
            skipArray[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        int length = s.length();
        for (int i = 0; i < length; i++) {
            char origin = s.charAt(i);
            int increased = 0;
            char changed = origin;

            while (true) {
                changed = (char) (changed + 1);

                // When alphabet overflows.
                if (changed > 'z') {
                    changed = (char) ('a' + (changed - 'z' - 1));
                }

                if (skipArray[changed - 'a'] == 0) {
                    increased++;
                }

                if (increased == index) {
                    break;
                }
            }

            sb.append(changed);
        }

        return sb.toString();
    }

}
