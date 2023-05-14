package io.github.imsejin.study.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class P1152 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))) {
            String sentence = reader.readLine();
            int wordCount = solve1(sentence);

            writer.println(wordCount);
        }
    }

    private static int solve1(String sentence) {
        if (sentence.isBlank()) {
            return 0;
        }

        int len = sentence.length();
        int startIndex = sentence.charAt(0) == ' ' ? 1 : 0;
        int endIndex = sentence.charAt(len - 1) == ' ' ? len - 2 : len - 1;

        int wordCount = 1;
        for (int i = startIndex; i <= endIndex; i++) {
            char c = sentence.charAt(i);
            if (c == ' ') wordCount++;
        }

        return wordCount;
    }

    private static int solve2(String sentence) {
        String[] words = sentence.split(" ");

        if (words.length == 0) {
            return 0;
        }

        return words[0].isEmpty() ? words.length - 1 : words.length;
    }

}
