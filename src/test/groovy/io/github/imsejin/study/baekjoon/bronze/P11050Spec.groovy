package io.github.imsejin.study.baekjoon.bronze

import spock.lang.Specification

class P11050Spec extends Specification {

    def "test"() {
        when:
        def actual = P11050.combination(n, r)

        then:
        actual == result

        where:
        n | r || result
        0 | 0 || 1
        3 | 0 || 1
        3 | 3 || 1
        5 | 1 || 5
        5 | 2 || 10
        5 | 3 || 10
        5 | 4 || 5
        5 | 5 || 1
    }

    def "factorial"() {
        when:
        def actual = P11050.factorial(n)

        then:
        actual == result

        where:
        n | result
        0 | 1
        1 | 1
        2 | 2
        3 | 6
        4 | 24
        5 | 120
        6 | 720
    }

}
