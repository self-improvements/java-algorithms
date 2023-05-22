package io.github.imsejin.study.baekjoon.silver

import spock.lang.Specification

class P2839Spec extends Specification {

    def "solve1"() {
        when:
        def actual = P2839.solve1(weight)

        then:
        actual == expected

        where:
        weight | expected
        18     | 4
        4      | -1
        6      | 2
        9      | 3
        11     | 3
        3      | 1
        6      | 2
        5      | 1
        16     | 4
    }

    def "solve2"() {
        when:
        def actual = P2839.solve2(weight)

        then:
        actual == expected

        where:
        weight | expected
        18     | 4
        4      | -1
        6      | 2
        9      | 3
        11     | 3
        3      | 1
        6      | 2
        5      | 1
        16     | 4
    }

}
