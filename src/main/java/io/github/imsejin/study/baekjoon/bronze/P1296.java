package io.github.imsejin.study.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P1296 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String memberName = reader.readLine();

            String[] teamNames = new String[Integer.parseInt(reader.readLine())];
            for (int i = 0; i < teamNames.length; i++) {
                teamNames[i] = reader.readLine();
            }

            String answer = solve(memberName, teamNames);
            System.out.println(answer);
        }
    }

    static String solve(String memberName, String[] teamNames) {
        Arrays.sort(teamNames);

        String teamName = teamNames[0];
        int probability = 0;
        Map<Character, Integer> m = groupByCounting(memberName);

        for (String name : teamNames) {
            Map<Character, Integer> t = groupByCounting(name);
            int l = m.getOrDefault('L', 0) + t.getOrDefault('L', 0);
            int o = m.getOrDefault('O', 0) + t.getOrDefault('O', 0);
            int v = m.getOrDefault('V', 0) + t.getOrDefault('V', 0);
            int e = m.getOrDefault('E', 0) + t.getOrDefault('E', 0);

            int score = calculate(l, o, v, e);

            if (probability < score) {
                probability = score;
                teamName = name;
            }
        }

        return teamName;
    }

    private static Map<Character, Integer> groupByCounting(String s) {
        Map<Character, Integer> group = new HashMap<>();

        for (char c : s.toCharArray()) {
            switch (c) {
                case 'L', 'O', 'V', 'E' -> group.compute(c, (k, v) -> v == null ? 1 : v + 1);
            }
        }

        return group;
    }

    private static int calculate(int l, int o, int v, int e) {
        return ((l + o) * (l + v) * (l + e) * (o + v) * (o + e) * (v + e)) % 100;
    }

}
