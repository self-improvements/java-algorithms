package io.github.imsejin.study.baekjoon.silver;

import io.github.imsejin.study.meta.Problem;
import io.github.imsejin.study.meta.Tag;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

@Problem(tags = {
        Tag.ALGEBRA,
})
public class P1676 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            int answer = solve1(n);
            System.out.println(answer);
        }
    }

    static int solve1(int n) {
        int zeroCount = 0;

        // n/5 + n/25 + n/125 + ...
        for (int i = 1, pow = 0; pow <= n; i++) {
            pow = (int) Math.pow(5, i);
            zeroCount += n / pow;
        }

        return zeroCount;
    }

    static int solve2(int n) {
        int zeroCount = 0;

        // 0이나 5로 끝나는 자연수는 5의 배수다.
        // 5의 배수마다 5를 몇 번 곱했는지(몫) 계산한다.
        while (n >= 5) {
            zeroCount += n / 5;
            n /= 5; // 5의 제곱수라면 5로 나눠도 5의 배수가 남아있다.
        }

        return zeroCount;
    }

    static int solve3(int n) {
        BigInteger f = factorial(BigInteger.valueOf(n));
        int zeroCount = 0;

        while (BigInteger.ZERO.compareTo(f.mod(BigInteger.TEN)) == 0) {
            zeroCount++;
            f = f.divide(BigInteger.TEN);
        }

        return zeroCount;
    }

    private static BigInteger factorial(BigInteger n) {
        if (n.compareTo(BigInteger.ZERO) == 0) return BigInteger.ONE;

        BigInteger result = BigInteger.ONE;
        BigInteger temp = BigInteger.ONE;

        while (temp.compareTo(n) <= 0) {
            result = result.multiply(temp);
            temp = temp.add(BigInteger.ONE);
        }

        return result;
    }

}
