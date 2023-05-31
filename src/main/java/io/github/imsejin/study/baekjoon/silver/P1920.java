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
//                int index = Arrays.binarySearch(origins, target);
                int index = binarySearch(origins, target);
                sb.append(index < 0 ? 0 : 1).append('\n');
            }

            System.out.println(sb);
        }
    }

    static int binarySearch(int[] numbers, int target) {
        int low = 0;
        int pivot;
        int high = numbers.length - 1;

        while (low <= high) {
            pivot = (low + high) / 2;
            int value = numbers[pivot];

            if (value == target) {
                return pivot;
            } else if (value < target) {
                // Search to higher.
                low = pivot + 1;
            } else {
                // Search to lower.
                high = pivot - 1;
            }
        }

        return -1;
    }

}
