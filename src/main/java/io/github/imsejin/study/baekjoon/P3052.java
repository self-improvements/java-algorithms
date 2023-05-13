package io.github.imsejin.study.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class P3052 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Set<Integer> set = new HashSet<>();

            while (true) {
                String line = reader.readLine();

                if (line == null || line.isEmpty()) {
                    break;
                }

                int number = Integer.parseInt(line);
                set.add(number % 42);
            }

            System.out.println(set.size());
        }
    }

}
