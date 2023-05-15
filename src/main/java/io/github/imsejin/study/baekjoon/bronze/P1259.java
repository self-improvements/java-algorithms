package io.github.imsejin.study.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1259 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = reader.readLine();

                if (line == null || line.equals("0")) {
                    break;
                }

                int number = Integer.parseInt(line);
                String result = isPalindrome(number) ? "yes" : "no";

                sb.append(result).append('\n');
            }

            System.out.println(sb);
        }
    }

    private static boolean isPalindrome(int number) {
        if (getDigitCount(number) == 1) {
            return true;
        }

        int n = number;
        int palindrome = 0;
        while (n != 0) {
            palindrome *= 10;
            int remainder = n % 10;
            n /= 10;
            palindrome += remainder;
        }

        return palindrome == number;
    }

    private static int getDigitCount(int number) {
        return (int) Math.log10(number) + 1;
    }

}
