package io.github.imsejin.study.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class P15829 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            reader.readLine();
            String string = reader.readLine();

            BigInteger answer = solve2(string);
            System.out.println(answer);
        }
    }

    static int solveLarge2(String string) {
        int digit = 0;
        final int m = 1234567891;

        // TODO: overflow 조심
        // a = bq + r ... r = a - bq ... q = a/b
        for (int i = 0; i < string.length(); i++) {
            int n = string.charAt(i) - 'a' + 1;
//            digit += (n * Math.pow(31, i)) % m;
            int term = n;

            for (int j = 0; j < i; j++) {
                term *= 31;
            }

            digit += (n * Math.pow(31, i)) % m;
        }

        return digit;
    }

    static BigInteger solve2(String string) {
        BigInteger digit = BigInteger.ZERO;
        BigInteger magicNumber = BigInteger.valueOf(31);
        BigInteger m = BigInteger.valueOf(1234567891);

        for (int i = 0; i < string.length(); i++) {
            int n = string.charAt(i) - 'a' + 1;
            digit = digit.add(BigInteger.valueOf(n).multiply(magicNumber.pow(i)).mod(m));
        }

        return digit;
    }

    static long solveSmall(String string) {
        long digit = 0;
        for (int i = 0; i < string.length(); i++) {
            int n = string.charAt(i) - 'a' + 1;
            digit += n * Math.pow(31, i);
        }

        return digit;
    }

}
