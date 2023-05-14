package io.github.imsejin.study.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Comparator.comparing;

public class P1157 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))) {
            String word = reader.readLine();
            char maxCharacter = solve1(word);

            writer.println(maxCharacter);
        }
    }

    private static char solve1(String word) {
        int[] codePoints = new int[word.length()];
        for (int i = 0; i < codePoints.length; i++) {
            codePoints[i] = Character.toUpperCase(word.charAt(i));
        }

        Arrays.sort(codePoints);

        int count = 1;
        Map<Integer, Character> map = new HashMap<>();

        for (int i = 1; i < codePoints.length; i++) {
            int before = codePoints[i - 1];
            int cur = codePoints[i];

            if (cur == before) {
                count++;
                continue;
            }

            if (map.containsKey(count)) {
                map.computeIfPresent(count, (k, v) -> '?');
            } else {
                map.put(count, (char) before);
            }

            count = 1;
        }

        // 마지막 문자의 개수를 저장한다.
        if (map.containsKey(count)) {
            map.computeIfPresent(count, (k, v) -> '?');
        } else {
            map.put(count, (char) codePoints[codePoints.length - 1]);
        }

        int max = 0;
        for (Integer key : map.keySet()) {
            max = Math.max(max, key);
        }

        return map.get(max);
    }

    private static char solve2(String word) {
        char[] chars = new char[word.length()];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = Character.toUpperCase(word.charAt(i));
        }

        Arrays.sort(chars);

        // Back reference: 캡처한 그룹을 역참조.
        Pattern pattern = Pattern.compile("[^A-Z]*([A-Z])\\1*");
        Matcher matcher = pattern.matcher(new String(chars));

        List<String> fragments = new ArrayList<>();
        while (matcher.find()) {
            String fragment = matcher.group();
            fragments.add(fragment);
        }

        fragments.sort(comparing(String::length).reversed());

        if (fragments.size() == 1) {
            return fragments.get(0).charAt(0);
        }

        String first = fragments.get(0);
        String second = fragments.get(1);

        return first.length() == second.length() ? '?' : first.charAt(0);
    }

}
