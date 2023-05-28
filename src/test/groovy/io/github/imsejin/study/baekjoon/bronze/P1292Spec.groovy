package io.github.imsejin.study.baekjoon.bronze

import spock.lang.Specification

class P1292Spec extends Specification {

    def "test"() {
        when:
        def actual = P1292.solve(start, end)

        then:
        actual == expected

        where:
        start | end || expected
        3     | 7   || 15
        10    | 10  || 4
        1     | 10  || 30
        1     | 100 || 945
    }

}
