package io.github.imsejin.study.baekjoon.bronze

import spock.lang.Specification

class P2292Spec extends Specification {

    def "test"() {
        when:
        def actual = P2292.solve(n)

        then:
        actual == expected

        where:
        n  | expected
        1  | 1
        3  | 2
        13 | 3
        19 | 3
        21 | 4
        37 | 4
        42 | 5
    }

}
