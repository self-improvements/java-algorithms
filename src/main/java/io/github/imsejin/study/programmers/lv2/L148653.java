package io.github.imsejin.study.programmers.lv2;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/148653">마법의 엘리베이터</a>
 */
public class L148653 {

    static int solve(int storey) {
        int[] digits = split(storey);
        int magicCount = 0;

        int i = digits.length - 1;
        do {
            int number = digits[i];

            if (number == 5) {
                if (digits[i - 1] >= 5) {
                    digits[i - 1]++;
                }

                magicCount += 5;
            } else if (number > 5) {
                digits[i - 1]++;
                magicCount += 10 - number;
            } else {
                magicCount += number;
            }

            digits[i] = 0;

            i--;
        } while (!isOnGround(digits));

        return magicCount;
    }

    private static boolean isOnGround(int[] digits) {
        for (int digit : digits) {
            if (digit != 0) return false;
        }

        return true;
    }

    private static int[] split(int number) {
        int[] digits = new int[getDigitCount(number) + 1];

        int index = digits.length - 1;
        while (number > 0) {
            digits[index] = number % 10;
            number /= 10;

            index--;
        }

        return digits;
    }

    private static int getDigitCount(int number) {
        return (int) Math.log10(number) + 1;
    }

}
