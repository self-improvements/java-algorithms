package io.github.imsejin.study.baekjoon.step2;

import java.io.*;

public class P14681 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(reader.readLine());
        int y = Integer.parseInt(reader.readLine());

        reader.close();

        if (x == 0 || y == 0) {
            throw new AssertionError("x == 0 || y == 0");
        }

        PrintWriter writer =
                new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        // 1사분면 기준
        int quadrant = 1;

        // 3사분면 or 4사분면
        if (y < 0) {
            quadrant += 2;
        }

        // 양수 * 음수 = 음수
        // 음수 * 양수 = 음수
        if (x * y < 0) {
            quadrant += 1;
        }

        writer.println(quadrant);
        writer.close();
    }

}
