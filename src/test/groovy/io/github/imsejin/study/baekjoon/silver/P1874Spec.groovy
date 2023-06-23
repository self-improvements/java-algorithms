package io.github.imsejin.study.baekjoon.silver

import spock.lang.Specification

class P1874Spec extends Specification {

    def "test"() {
        when:
        def actual = P1874.solve(sequence as int[])

        then:
        actual == expected as String[]

        where:
        sequence                 | expected
        [4, 3, 6, 8, 7, 5, 2, 1] | ["+", "+", "+", "+", "-", "-", "+", "+", "-", "+", "+", "-", "-", "-", "-", "-"]
    }

}
