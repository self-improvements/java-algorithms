package io.github.imsejin.study.programmers

import spock.lang.Specification

class L120875Spec extends Specification {

    def "test"() {
        when:
        def actual = L120875.solve(dots as int[][])

        then:
        actual == result

        where:
        dots                              | result
        [[1, 4], [9, 2], [3, 8], [11, 6]] | 1
        [[3, 5], [4, 1], [2, 4], [5, 10]] | 0
    }

}
