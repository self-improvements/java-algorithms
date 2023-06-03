package io.github.imsejin.study.baekjoon.bronze

import spock.lang.Specification

class P1526Spec extends Specification {

    def "test"() {
        when:
        def actual = P1526.solve(number)

        then:
        actual == expected

        where:
        number | expected
        100    | 77
        75     | 74
        47     | 47
        5      | 4
        474747 | 474747
    }

}
