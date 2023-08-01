package io.github.imsejin.study.programmers.lv1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/160586">대충 만든 자판</a>
 */
public class L160586 {

    static int[] solve(String[] keymap, String[] targets) {
        int maxLength = Arrays.stream(keymap).mapToInt(String::length).max().getAsInt();
        for (int i = 0; i < keymap.length; i++) {
            keymap[i] = String.format("%-" + maxLength + "s", keymap[i]);
        }

        Map<Character, Integer> alphabetMap = new HashMap<>();
        for (int i = 0; i < maxLength; i++) {
            for (int j = 0; j < keymap.length; j++) {
                char c = keymap[j].charAt(i);
                alphabetMap.putIfAbsent(c, i + 1);
            }
        }

        int[] counts = new int[targets.length];
        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int length = target.length();

            int count = 0;
            for (int j = 0; j < length; j++) {
                char c = target.charAt(j);
                Integer number = alphabetMap.get(c);

                if (number != null) {
                    count += number;
                } else {
                    count = -1;
                    break;
                }
            }

            counts[i] = count;
        }

        return counts;
    }

}
