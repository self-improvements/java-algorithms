package io.github.imsejin.study.programmers.lv1

import spock.lang.Specification

class L161990Spec extends Specification {

    def "test"() {
        when:
        def actual = L161990.solve0(wallpaper as String[])

        then:
        actual == expected as int[]
        actual == L161990.solve1(wallpaper as String[])

        where:
        wallpaper                                                                                   | expected
        [".#...", "..#..", "...#."]                                                                 | [0, 1, 3, 4]
        ["..........", ".....#....", "......##..", "...##.....", "....#....."]                      | [1, 3, 5, 8]
        [".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."] | [0, 0, 7, 9]
        ["..", "#."]                                                                                | [1, 0, 2, 1]
    }

}
