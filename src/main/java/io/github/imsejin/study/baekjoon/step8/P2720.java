package io.github.imsejin.study.baekjoon.step8;

import java.io.*;

public class P2720 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer =
                new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int testCaseCount = Integer.parseInt(reader.readLine());
        for (int i = 0; i < testCaseCount; i++) {
            int change = Integer.parseInt(reader.readLine());
            int quarter = 0;
            int dime = 0;
            int nickel = 0;
            int penny = 0;

            if (change >= 25) {
                quarter = change / 25;
                change %= 25;
            }
            if (change >= 10) {
                dime = change / 10;
                change %= 10;
            }
            if (change >= 5) {
                nickel = change / 5;
                change %= 5;
            }
            if (change >= 1) {
                penny = change;
                change = 0;
            }

            writer.printf("%d %d %d %d%n", quarter, dime, nickel, penny);
        }

        reader.close();
        writer.close();
    }

}
