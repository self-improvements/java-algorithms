package io.github.imsejin.study.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1032 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int count = Integer.parseInt(reader.readLine());

            String[] fileNames = new String[count];
            for (int i = 0; i < fileNames.length; i++) {
                String fileName = reader.readLine();
                fileNames[i] = fileName;
            }

            if (fileNames.length == 1) {
                System.out.println(fileNames[0]);
                return;
            }

            char[] chars = fileNames[0].toCharArray();

            for (int i = 1; i < fileNames.length; i++) {
                String fileName = fileNames[i];

                for (int j = 0; j < chars.length; j++) {
                    char base = chars[j];
                    char current = fileName.charAt(j);

                    if (base != current) {
                        chars[j] = '?';
                    }
                }
            }

            System.out.println(chars);
        }
    }

}
