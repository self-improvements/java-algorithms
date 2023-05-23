package io.github.imsejin.study.baekjoon.bronze;

import io.github.imsejin.study.meta.Problem;
import io.github.imsejin.study.meta.Tag;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Problem(tags = {
        Tag.DYNAMIC_PROGRAMMING,
})
public class P2775 {

    private static final int[][] cache = new int[15][14];

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int testCaseCount = Integer.parseInt(reader.readLine());
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < testCaseCount; i++) {
                int k = Integer.parseInt(reader.readLine());
                int n = Integer.parseInt(reader.readLine());

                int answer = solve(k, n);
                sb.append(answer).append('\n');
            }

            System.out.println(sb);
        }
    }

    static int solve(int floor, int room) {
        for (int i = 0; i < room; i++) {
            cache[0][i] = i + 1;
        }

        if (room == 1) {
            return 1;
        }

        if (cache[floor][room - 1] > 0) {
            return cache[floor][room - 1];
        }

        for (int i = 1; i <= floor; i++) {
            // 캐시된 층을 다시 계산하지 않는다.
            if (cache[i][room - 1] > 0) continue;

            for (int j = 0; j < room; j++) {
                // 캐시된 방을 다시 계산하지 않는다.
                if (cache[i][j] > 0) continue;

                int residentCount;
                if (j == 0) {
                    // 각 층의 1호는 1명만 살아야 한다.
                    residentCount = 1;
                } else {
                    residentCount = cache[i][j - 1] + cache[i - 1][j];
                }

                cache[i][j] = residentCount;
            }
        }

        return cache[floor][room - 1];
    }

}
