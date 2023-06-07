package io.github.imsejin.study.baekjoon.silver

import spock.lang.Specification

class P10773Spec extends Specification {

    def "test"() {
        when:
        def actual = P10773.solve(numbers as int[])

        then:
        actual == expected

        where:
        numbers                        | expected
        [3, 0, 4, 0]                   | 0
        [10, 20, 40, 0, 0, 0]          | 0
        [9, 10, 8, 1000000, 3]         | 1000030
        [1, 3, 5, 4, 0, 0, 7, 0, 0, 6] | 7
    }

}
