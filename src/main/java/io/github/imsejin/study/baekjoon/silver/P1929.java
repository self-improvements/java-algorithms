package io.github.imsejin.study.baekjoon.silver;

import io.github.imsejin.study.meta.Problem;
import io.github.imsejin.study.meta.Tag;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

@Problem(tags = {
        Tag.ALGEBRA,
})
public class P1929 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());

            int[] answers = solve1(start, end);
            StringBuilder sb = new StringBuilder();
            for (int answer : answers) {
                sb.append(answer).append('\n');
            }

            System.out.println(sb);
        }
    }

    static int[] solve1(int start, int end) {
        boolean[] sieve = new boolean[end + 1];

        // 0, 1을 거른다.
        sieve[0] = true;
        sieve[1] = true;

        /*
        16의 약수는 1,2,4,8,16이다.
        중간값 4를 기준으로 (1,16), (2,8), (4,4), (8,2), (16,1) 양쪽으로 대칭되고 있음을 알 수 있다.
        16의 약수를 찾고 싶다면 중간값을 기준으로 한쪽 방향에 나열된 수만 찾으면 된다.

        즉 1~4에 약수가 있는지 판별하면 5~15(N-1 = 15)에 약수가 있는지는 확인할 필요가 없다.
         */
        double sqrt = Math.sqrt(end);

        for (int i = 2; i <= sqrt; i++) {
            // 걸러진 수는 넘어간다.
            if (sieve[i]) continue;

            // 걸러지지 않은 수를 제외한 그 수의 배수를 거른다.
            int j = 2;
            while (i * j <= end) {
                sieve[i * j] = true;
                j++;
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            if (!sieve[i]) primes.add(i);
        }

        return primes.stream().mapToInt(it -> it).toArray();
    }

    static int[] solve2(int start, int end) {
        int[] primes = new int[end + 1];

        for (int i = start; i <= end; i++) {
            if (isPrime(i)) primes[i] = i;
        }

        return Arrays.stream(primes).filter(it -> it > 0).toArray();
    }

    private static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        double sqrt = Math.sqrt(n);
        for (int i = 3; i <= sqrt; i++) {
            if (n % i == 0) return false;
        }

        return true;
    }

}
