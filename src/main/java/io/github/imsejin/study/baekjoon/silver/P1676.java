package io.github.imsejin.study.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

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
        long accumulator = 1;

        while (n >= 2) {
            accumulator *= n--;

            // 0으로 끝난다는 건 10의 배수다.
            if (accumulator % 10 == 0) {
                zeroCount++;
                // 10으로 나눠서 카운트한 0을 제거한다.
                // overflow를 방지한다.
                accumulator /= 10;
            }
        }

        return zeroCount;
    }

    static int solve2(int n) {
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

        while (temp.compareTo(n) != 0) {
            result = result.multiply(temp);
            temp = temp.add(BigInteger.ONE);
        }

        return result.multiply(n);
    }

}
