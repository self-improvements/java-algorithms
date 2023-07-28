package io.github.imsejin.study.programmers.lv1;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/161990">바탕화면 정리</a>
 */
public class L161990 {

    static int[] solve0(String[] wallpaper) {
        List<Coordinate> coordinates = new ArrayList<>();

        for (int i = 0; i < wallpaper.length; i++) {
            String row = wallpaper[i];
            for (int j = 0; j < row.length(); j++) {
                char c = row.charAt(j);
                if (c == '.') continue;
                coordinates.add(new Coordinate(i, j));
            }
        }

        int upperY = coordinates.stream().mapToInt(it -> it.y).min().getAsInt();
        int upperX = coordinates.stream().mapToInt(it -> it.x).min().getAsInt();
        int downY = coordinates.stream().mapToInt(it -> it.y).max().getAsInt();
        int downX = coordinates.stream().mapToInt(it -> it.x).max().getAsInt();

        return new int[]{upperY, upperX, downY + 1, downX + 1};
    }

    static int[] solve1(String[] wallpaper) {
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;

        for (int i = 0; i < wallpaper.length; i++) {
            String row = wallpaper[i];
            for (int j = 0; j < row.length(); j++) {
                char c = row.charAt(j);
                if (c == '.') continue;

                minX = Math.min(minX, j);
                maxX = Math.max(maxX, j);
                minY = Math.min(minY, i);
                maxY = Math.max(maxY, i);
            }
        }

        return new int[]{minY, minX, maxY + 1, maxX + 1};
    }

    // -------------------------------------------------------------------------------------------------

    private static class Coordinate {
        private final int y;
        private final int x;

        public Coordinate(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

}
