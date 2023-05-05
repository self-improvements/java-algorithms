package io.github.imsejin.study.programmers

import spock.lang.Specification

class L181931Spec extends Specification {

    def "test"() {
        when:
        def actual = L181931.solve(a, d, included as boolean[])

        then:
        actual == sum

        where:
        a | d | included                                         || sum
        3 | 4 | [true, false, false, true, true]                 || 37
        7 | 1 | [false, false, false, true, false, false, false] || 10
    }

}
