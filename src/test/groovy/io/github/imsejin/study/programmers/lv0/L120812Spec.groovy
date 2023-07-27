package io.github.imsejin.study.programmers.lv0

import spock.lang.Specification

class L120812Spec extends Specification {

    def "test"() {
        when:
        def actual = L120812.solve(numbers as int[])

        then:
        actual == expected

        where:
        numbers            | expected
        [1, 2, 3, 3, 3, 4] | 3
        [1, 1, 2, 2]       | -1
        [1]                | 1
    }

}
