package io.github.imsejin.study.programmers.lv1;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/118666">성격 유형 검사하기</a>
 */
public class L118666 {

    static String solve(String[] survey, int[] choiceList) {
        Choice[] choices = new Choice[choiceList.length];
        for (int i = 0; i < choices.length; i++) {
            choices[i] = Choice.from(choiceList[i]);
        }

        Map<Character, Integer> scoreMap = new HashMap<>();
        EnumSet.allOf(Indicator.class).stream()
                .flatMap(it -> Stream.of(it.first, it.second))
                .forEach(key -> scoreMap.put(key, 0));

        for (int i = 0; i < survey.length; i++) {
            char first = survey[i].charAt(0);
            char second = survey[i].charAt(1);
            Choice choice = choices[i];

            if (choice.score == 0) continue;

            if (choice.ordinal() < Choice.UNCERTAIN.ordinal()) {
                scoreMap.computeIfPresent(first, (k, v) -> v + choice.score);
            } else {
                scoreMap.computeIfPresent(second, (k, v) -> v + choice.score);
            }
        }

        return EnumSet.allOf(Indicator.class).stream()
                .collect(StringBuilder::new,
                        (acc, cur) -> acc.append(getBiggerIndicator(scoreMap, cur)),
                        StringBuilder::append)
                .toString();
    }

    private static char getBiggerIndicator(Map<Character, Integer> scoreMap, Indicator indicator) {
        int a = scoreMap.get(indicator.first);
        int b = scoreMap.get(indicator.second);

        return a >= b ? indicator.first : indicator.second;
    }

    // -------------------------------------------------------------------------------------------------

    private enum Indicator {
        ALPHA('R', 'T'),
        BETA('C', 'F'),
        GAMMA('J', 'M'),
        DELTA('A', 'N');

        private final char first;
        private final char second;

        Indicator(char first, char second) {
            this.first = first;
            this.second = second;
        }
    }

    private enum Choice {
        VERY_NEGATIVE(3), // 매우 비동의
        NEGATIVE(2), // 비동의
        LITTLE_NEGATIVE(1), // 약간 비동의
        UNCERTAIN(0), // 모르겠음
        LITTLE_POSITIVE(1), // 약간 동의
        POSITIVE(2), // 동의
        VERY_POSITIVE(3); // 매우 동의

        private static final Map<Integer, Choice> cache = Arrays.stream(values())
                .collect(toMap(it -> it.ordinal() + 1, it -> it));

        private final int score;

        Choice(int score) {
            this.score = score;
        }

        public static Choice from(int n) {
            return cache.get(n);
        }
    }

}
