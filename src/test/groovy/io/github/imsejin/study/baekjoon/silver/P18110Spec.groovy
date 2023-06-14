package io.github.imsejin.study.baekjoon.silver

import spock.lang.Specification

class P18110Spec extends Specification {

    def "test"() {
        when:
        def actual = P18110.solve(difficulties as int[])

        then:
        actual == expected

        where:
        difficulties                           | expected
        [1, 5, 5, 7, 8]                        | 6
        [1, 13, 12, 15, 3, 16, 13, 12, 14, 15] | 13
    }

}
