package io.github.imsejin.study.baekjoon.bronze

import spock.lang.Specification

class P1357Spec extends Specification {

    def "Reverse"() {
        when:
        def actual = P1357.reverse(number)

        then:
        actual == expected

        where:
        number | expected
        5      | 5
        22     | 22
        98     | 89
        100    | 1
        123    | 321
        2020   | 202
    }

}
