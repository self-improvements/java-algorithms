package io.github.imsejin.study.baekjoon.bronze

import spock.lang.Specification

class P2775Spec extends Specification {

    def "test"() {
        when:
        def actual = P2775.solve(k, n)

        then:
        actual == expected

        where:
        k | n || expected
//        1 | 3 || 6
        2 | 3 || 10
    }

}
