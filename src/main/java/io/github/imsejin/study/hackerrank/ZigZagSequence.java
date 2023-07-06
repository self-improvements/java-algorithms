package io.github.imsejin.study.hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ZigZagSequence {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int caseCount = Integer.parseInt(reader.readLine());

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < caseCount; i++) {
                reader.readLine(); // Ignored
                int[] numbers = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int[] answer = solve(numbers);

                for (int n : answer) {
                    sb.append(n).append(' ');
                }
                sb.append('\n');
            }

            System.out.println(sb);
        }
    }

    static int[] solve(int[] numbers) {
        if (numbers.length == 1) {
            return new int[]{numbers[0]};
        }

        Arrays.sort(numbers);

        int pivot = ((numbers.length + 1) / 2) - 1;
        int[] result = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            int n = numbers[i];

            if (i < pivot) {
                result[i] = n;
            } else {
                result[numbers.length - (i - pivot) - 1] = n;
            }
        }

        return result;
    }

}
