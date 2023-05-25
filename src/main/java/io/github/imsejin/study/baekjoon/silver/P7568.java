package io.github.imsejin.study.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P7568 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int count = Integer.parseInt(reader.readLine());

            String[] lines = new String[count];
            for (int i = 0; i < lines.length; i++) {
                lines[i] = reader.readLine();
            }

            int[] ranks = solve(lines);

            StringBuilder sb = new StringBuilder();
            for (int rank : ranks) {
                sb.append(rank).append(' ');
            }

            System.out.println(sb);
        }
    }

    static int[] solve(String[] members) {
        Human[] people = new Human[members.length];
        for (int i = 0; i < people.length; i++) {
            people[i] = Human.from(members[i]);
        }

        int[] ranks = new int[people.length];

        for (int i = 0; i < people.length; i++) {
            for (int j = 0; j < people.length; j++) {
                if (i == j) continue;

                if (people[i].weight < people[j].weight && people[i].height < people[j].height) {
                    people[i].rank++;
                }
            }

            ranks[i] = people[i].rank;
        }

        return ranks;
    }

    private static class Human {
        private final int weight;
        private final int height;
        private int rank = 1;

        private Human(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }

        public static Human from(String expression) {
            StringTokenizer tokenizer = new StringTokenizer(expression);
            int weight = Integer.parseInt(tokenizer.nextToken());
            int height = Integer.parseInt(tokenizer.nextToken());

            return new Human(weight, height);
        }

        @Override
        public String toString() {
            return String.format("Human(weight=%d, height=%d, rank=%d)", weight, height, rank);
        }
    }

}
