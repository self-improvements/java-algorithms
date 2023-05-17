package io.github.imsejin.study.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class P11866 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(tokenizer.nextToken());
            int k = Integer.parseInt(tokenizer.nextToken());

            String answer = solve(n, k);

            System.out.println(answer);
        }
    }

    static String solve(int n, int k) {
        StringBuilder sb = new StringBuilder("<");
        List<Integer> seats = new LinkedList<>(IntStream.rangeClosed(1, n).boxed().collect(toList()));

        int cursor = k - 1;
        while (seats.size() > 1) {
            Integer seat = seats.get(cursor);
            sb.append(seat).append(", ");
            seats.remove(cursor);

            cursor += k - 1;
            if (cursor >= seats.size()) {
                cursor %= seats.size();
            }
        }

        sb.append(seats.get(0)).append('>');
        return sb.toString();
    }

}
