package io.github.imsejin.study.baekjoon.silver;

import io.github.imsejin.study.meta.Problem;
import io.github.imsejin.study.meta.Tag;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

@Problem(tags = {
        Tag.SEARCH,
        Tag.SORTING,
})
public class P1920 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            reader.readLine();
            int[] origins = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).sorted().toArray();
            reader.readLine();
            int[] targets = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            StringBuilder sb = new StringBuilder();
            for (int target : targets) {
                int index = Arrays.binarySearch(origins, target);
//                int index = solve(origins, target);
                sb.append(index < 0 ? 0 : 1).append('\n');
            }

            System.out.println(sb);
        }
    }

    static int solve(int[] numbers, int target) {
        return 0;
    }

}
