package io.github.imsejin.study.baekjoon.silver

import spock.lang.Specification

class P1016Spec extends Specification {

    def "test"() {
        given:
        def board = lines.readLines().collect { it.toCharArray() } as char[][]

        when:
        def actual = P1016.solve(board)

        then:
        actual == expected

        where:
        lines                       | expected
        "BBBBBBBBWBWBW\n" +
                "BBBBBBBBBWBWB\n" +
                "BBBBBBBBWBWBW\n" +
                "BBBBBBBBBWBWB\n" +
                "BBBBBBBBWBWBW\n" +
                "BBBBBBBBBWBWB\n" +
                "BBBBBBBBWBWBW\n" +
                "BBBBBBBBBWBWB\n" +
                "WWWWWWWWWWBWB\n" +
                "WWWWWWWWWWBWB"     | 12
    }

}
