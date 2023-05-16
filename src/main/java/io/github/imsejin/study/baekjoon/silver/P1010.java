package io.github.imsejin.study.baekjoon.silver;

import io.github.imsejin.study.meta.Problem;
import io.github.imsejin.study.meta.Tag;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

@Problem(tags = {
        Tag.COMBINATION,
        Tag.PASCAL_TRIANGLE,
})
public class P1010 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))) {
            reader.readLine();

            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = reader.readLine();
                if (line == null || line.isEmpty()) {
                    break;
                }

                // nC0 = nCn = 1
                // (n+1)C(r+1) = nCr + nC(r+1)
                StringTokenizer tokenizer = new StringTokenizer(line);
                int n = Integer.parseInt(tokenizer.nextToken());
                int m = Integer.parseInt(tokenizer.nextToken());
                long answer = factorial5(m, n);
                sb.append(answer).append('\n');
            }

            writer.println(sb);
        }
    }

    // 입력값 < 30 ... 0~29의 숫자를 메모이제이션하도록 크기 30의 배열을 생성한다.
    private static long[][] cache = new long[30][30];

    private static long factorial5(int n, int r) {
        if (cache[n][r] > 0) {
            return cache[n][r];
        }

        if (n == r || r == 0) {
            cache[n][r] = 1;
            return 1;
        }

        cache[n][r] = factorial5(n - 1, r - 1) + factorial5(n - 1, r);
        return cache[n][r];
    }

    /*private static long solve(int[] numbers) {
        // combination
        int n = numbers[0];
        int m = numbers[1];

        if (n == m) return 1;
        if (n == 1) return m;

        // nPr = n! / (n - r)!
        // nCr = nPr / r!
        // return factorial2(m) / factorial2(m - n) / factorial2(n);
        // return factorial3(m - n + 1, m) / factorial2(n);
        // return factorial4(m, n);
        return factorial5(m, n);
    }

    private static long factorial1(int number) {
        if (number <= 1) {
            return 1;
        }

        return number * factorial1(number - 1);
    }

    private static long factorial2(int number) {
        long result = 1;
        while (number > 1) {
            result *= number--;
        }

        return result;
    }

    private static long factorial3(int start, int end) {
        long result = start;
        while (start < end) {
            result *= ++start;
        }

        return result;
    }

    private static long factorial4(int n, int r) {
        if (n == r || r == 0) return 1;

        return factorial4(n - 1, r - 1) + factorial4(n - 1, r);
    }*/

}
