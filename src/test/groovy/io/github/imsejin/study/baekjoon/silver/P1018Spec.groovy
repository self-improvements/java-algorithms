package io.github.imsejin.study.baekjoon.silver

import spock.lang.Specification

class P1018Spec extends Specification {

    def "test"() {
        given:
        def board = lines.collect { it.toCharArray() } as char[][]

        when:
        def actual = P1018.Line.solve(board)

        then:
        actual == expected
        actual == P1018.OddEven.solve(board)

        where:
        lines                       | expected
        ["WBWBWBWB",
         "BWBWBWBW",
         "WBWBWBWB",
         "BWBBBWBW",
         "WBWBWBWB",
         "BWBWBWBW",
         "WBWBWBWB",
         "BWBWBWBW"]                | 1
        ["BBBBBBBBWBWBW",
         "BBBBBBBBBWBWB",
         "BBBBBBBBWBWBW",
         "BBBBBBBBBWBWB",
         "BBBBBBBBWBWBW",
         "BBBBBBBBBWBWB",
         "BBBBBBBBWBWBW",
         "BBBBBBBBBWBWB",
         "WWWWWWWWWWBWB",
         "WWWWWWWWWWBWB"]           | 12
        ["BWBWBWBW",
         "WBWBWBWB",
         "BWBWBWBW",
         "WBWBWBWB",
         "BWBWBWBW",
         "WBWBWBWB",
         "BWBWBWBW",
         "WBWBWBWB"]                | 0
        ["BBBBBBBB",
         "BBBBBBBB",
         "BBBBBBBB",
         "BBBBBBBB",
         "BBBBBBBB",
         "BBBBBBBB",
         "BBBBBBBB",
         "BBBBBBBB",
         "BBBBBBBW"]                | 31
        ["BBBBBBBBBBBBBBBBBBBBBBB",
         "BBBBBBBBBBBBBBBBBBBBBBB",
         "BBBBBBBBBBBBBBBBBBBBBBB",
         "BBBBBBBBBBBBBBBBBBBBBBB",
         "BBBBBBBBBBBBBBBBBBBBBBB",
         "BBBBBBBBBBBBBBBBBBBBBBB",
         "BBBBBBBBBBBBBBBBBBBBBBB",
         "BBBBBBBBBBBBBBBBBBBBBBB",
         "BBBBBBBBBBBBBBBBBBBBBBW"] | 31
        ["BBBBBBBBBB",
         "BBWBWBWBWB",
         "BWBWBWBWBB",
         "BBWBWBWBWB",
         "BWBWBWBWBB",
         "BBWBWBWBWB",
         "BWBWBWBWBB",
         "BBWBWBWBWB",
         "BWBWBWBWBB",
         "BBBBBBBBBB"]              | 0
        ["WBWBWBWB",
         "BWBWBWBW",
         "WBWBWBWB",
         "BWBBBWBW",
         "WBWBWBWB",
         "BWBWBWBW",
         "WBWBWWWB",
         "BWBWBWBW"]                | 2
        ["BWWBWWBWWBWW",
         "BWWBWBBWWBWW",
         "WBWWBWBBWWBW",
         "BWWBWBBWWBWW",
         "WBWWBWBBWWBW",
         "BWWBWBBWWBWW",
         "WBWWBWBBWWBW",
         "BWWBWBWWWBWW",
         "WBWWBWBBWWBW",
         "BWWBWBBWWBWW",
         "WBWWBWBBWWBW"]            | 15
    }

}
