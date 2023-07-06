package io.github.imsejin.study.baekjoon.silver

import spock.lang.Specification

class P1929Spec extends Specification {

    def "test"() {
        when:
        def actual = P1929.solve1(start, end)

        then:
        actual == expected as int[]
        actual == P1929.solve2(start, end)

        where:
        start | end || expected
        1     | 1   || []
        3     | 16  || [3, 5, 7, 11, 13]
        30    | 50  || [31, 37, 41, 43, 47]
        90    | 100 || [97]
        1     | 100 || [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97]
    }

}
