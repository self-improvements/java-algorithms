package io.github.imsejin.study.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class P8958 {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))) {
            int testCaseCount = Integer.parseInt(reader.readLine());

            for (int i = 0; i < testCaseCount; i++) {
                String result = reader.readLine();
                int answer = solve(result);
                writer.println(answer);
            }
        }
    }

    private static int solve(String result) {
        int sum = 0;
        int scorePerQuestion = 0;

        for (int i = 0; i < result.length(); i++) {
            char c = result.charAt(i);

            if (c == 'O') {
                scorePerQuestion++;
                sum += scorePerQuestion;
            } else {
                scorePerQuestion = 0;
            }
        }

        return sum;
    }

}
