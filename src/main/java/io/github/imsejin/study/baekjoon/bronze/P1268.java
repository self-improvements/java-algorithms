package io.github.imsejin.study.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1268 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int studentCount = Integer.parseInt(reader.readLine());
            int[][] table = new int[studentCount][];

            for (int i = 0; i < studentCount; i++) {
                int[] row = Arrays.stream(reader.readLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();
                table[i] = row;
            }

            int[] counts = new int[studentCount];
            // 학년
            for (int i = 0; i < 5; i++) {
                // 기준 학생
                for (int j = 0; j < studentCount - 1; j++) {
                    // 비교 학생
                    for (int k = j + 1; k < studentCount; k++) {
                        if (table[j][i] == table[k][i]) {
                            counts[j]++;
                            counts[k]++;
                        }
                    }
                }
            }

            int max = 0;
            int maxStudent = 0;
            for (int i = 0; i < studentCount; i++) {
                if (counts[i] > max) {
                    max = counts[i];
                    maxStudent = i;
                } else if (counts[i] == max) {
                    // 여러 명인 경우
                    if (maxStudent > i) {
                        maxStudent = i;
                    }
                }
            }

//            int index = 0;
//            int max = 0;
//            for (int i = 0; i < counts.length; i++) {
//                if (max < counts[i]) {
//                    max = counts[i];
//                    index = i;
//                }
//            }

            System.out.println(maxStudent + 1);
        }
    }

//    public static void main2(String[] args) throws Exception {
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
//            int studentCount = Integer.parseInt(reader.readLine());
//            int[][] table = new int[studentCount][];
//
//            for (int i = 0; i < studentCount; i++) {
//                int[] row = Arrays.stream(reader.readLine().split(" "))
//                        .mapToInt(Integer::parseInt).toArray();
//                table[i] = row;
//            }
//
//            Map<Integer, Integer> map = new HashMap<>();
//
//            for (int i = 0; i < 5; i++) {
//                for (int j = 0; j < studentCount - 1; j++) {
//                    int baseCell = table[j][i];
//
//                    for (int k = j + 1; k < studentCount; k++) {
//                        int targetCell = table[k][i];
//                        if (baseCell == targetCell) {
//                            putOrIncrease(map, j);
//                            putOrIncrease(map, k);
//                        }
//                    }
//                }
//            }
//
//            int max = 0;
//            for (Map.Entry<Integer, Integer> e : map.entrySet()) {
//                max = Math.max(max, e.getValue());
//            }
//
//            List<Map.Entry<Integer, Integer>> entries = map.entrySet().stream()
//                    .sorted(comparingByKey()).collect(toList());
//            for (Map.Entry<Integer, Integer> e : entries) {
//                if (e.getValue() == max) {
//                    System.out.println(e.getKey() + 1);
//                    break;
//                }
//            }
//        }
//    }
//
//    private static void putOrIncrease(Map<Integer, Integer> map, int key) {
//        if (map.containsKey(key)) {
//            map.computeIfPresent(key, (k, v) -> v + 1);
//        } else {
//            map.put(key, 1);
//        }
//    }

}
