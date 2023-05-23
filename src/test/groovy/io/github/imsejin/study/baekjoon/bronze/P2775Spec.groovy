package io.github.imsejin.study.baekjoon.bronze

import spock.lang.Specification

class P2775Spec extends Specification {

    def "test"() {
        when:
        def actual = P2775.solve(floor, room)

        then:
        actual == expected

        where:
        floor | room || expected
        1     | 3    || 6
        2     | 3    || 10
        3     | 1    || 1
        3     | 2    || 5
        3     | 3    || 15
        3     | 4    || 35
        4     | 3    || 21
        5     | 4    || 84
    }

}
