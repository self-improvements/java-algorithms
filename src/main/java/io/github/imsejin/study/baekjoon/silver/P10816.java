package io.github.imsejin.study.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P10816 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            reader.readLine();
            int[] cards = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            reader.readLine();
            int[] targets = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            String answer = solve1(cards, targets);
            System.out.println(answer);
        }
    }

    static String solve1(int[] cards, int[] targets) {
        Map<Integer, Integer> countMap = Arrays.stream(cards).boxed().collect(HashMap::new,
                (map, card) -> map.compute(card, (k, v) -> v == null ? 1 : v + 1), Map::putAll);

        StringBuilder sb = new StringBuilder();
        for (int target : targets) {
            sb.append(countMap.getOrDefault(target, 0)).append(' ');
        }
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

    static String solve2(int[] cards, int[] targets) {
        int[] cache = new int[20_000_001];

        for (int card : cards) {
            cache[card + 10_000_000]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int target : targets) {
            sb.append(cache[target + 10_000_000]).append(' ');
        }
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }


}
