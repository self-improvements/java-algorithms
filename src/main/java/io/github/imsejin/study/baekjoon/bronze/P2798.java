package io.github.imsejin.study.baekjoon.bronze;

import io.github.imsejin.study.meta.Problem;
import io.github.imsejin.study.meta.Tag;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

@Problem(tags = {
        Tag.COMBINATION,
})
public class P2798 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int blackjackNumber = Integer.parseInt(reader.readLine().split(" ")[1]);
            int[] cards = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            int answer = solve(cards, blackjackNumber);
            System.out.println(answer);
        }
    }

    static int solve(int[] cards, int n) {
        int result = 0;

        for (int i = 0; i < cards.length - 2; i++) {
            for (int j = i + 1; j < cards.length - 1; j++) {
                for (int k = j + 1; k < cards.length; k++) {
                    int sum = cards[i] + cards[j] + cards[k];

                    if (sum <= n && sum > result) result = sum;
                }
            }
        }

        return result;
    }

}
