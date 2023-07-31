package io.github.imsejin.study.programmers.lv1

import spock.lang.Specification

class L133502Spec extends Specification {

    def "test"() {
        when:
        def actual = L133502.solve(ingredient as int[])

        then:
        actual == expected

        where:
        ingredient                                 | expected
        [1, 3, 2, 1]                               | 0
        [1, 3, 2, 1, 2, 1, 3, 1, 2]                | 0
        [2, 3, 1, 3, 2, 1, 1, 2, 3, 3, 1]          | 0
        [1, 2, 3, 1]                               | 1
        [2, 1, 1, 2, 3, 1, 2, 3, 1]                | 2
        [2, 3, 1, 1, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1] | 3
        [1, 2, 1, 2, 1, 2, 3, 1, 3, 1, 3, 1]       | 3
    }

}
