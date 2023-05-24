package io.github.imsejin.study.baekjoon.silver

import spock.lang.Specification

class P1436Spec extends Specification {

    def "test"() {
        when:
        def actual = P1436.solve(degree)

        then:
        actual == expected

        where:
        degree | expected
        1      | 666
        2      | 1666
        6      | 5666
        7      | 6660
        8      | 6661
        16     | 6669
        17     | 7666
        18     | 8666
        19     | 9666
        20     | 10666
        21     | 11666
        187    | 66666
        500    | 166699
    }

}
