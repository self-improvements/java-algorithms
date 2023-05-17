package io.github.imsejin.study.baekjoon.silver;

import io.github.imsejin.study.meta.Problem;
import io.github.imsejin.study.meta.Tag;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.util.Comparator.comparing;

@Problem(tags = {
        Tag.SORTING,
})
public class P1181 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int count = Integer.parseInt(reader.readLine());

            // TODO: 중복 제거, length 먼저 정렬
            String[] words = new String[count];
            for (int i = 0; i < count; i++) {
                String word = reader.readLine();
                words[i] = word;
            }

            Arrays.sort(words, comparing(String::length).thenComparing(String::compareTo));

            StringBuilder sb = new StringBuilder();
            String duplicated = null;
            for (String word : words) {
                if (!word.equals(duplicated)) {
                    sb.append(word).append('\n');
                }

                duplicated = word;
            }

            System.out.println(sb);
        }
    }

}
