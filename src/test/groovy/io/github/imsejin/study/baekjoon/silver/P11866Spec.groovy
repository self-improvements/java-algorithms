package io.github.imsejin.study.baekjoon.silver

import spock.lang.Specification

class P11866Spec extends Specification {

    def "test"() {
        when:
        def actual = P11866.solve(n, k)

        then:
        actual == expected

        where:
        n | k || expected
        1 | 1 || "<1>"
        3 | 1 || "<1, 2, 3>"
        3 | 2 || "<2, 1, 3>"
        7 | 3 || "<3, 6, 2, 7, 5, 1, 4>"
    }

}
