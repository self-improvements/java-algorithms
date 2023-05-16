package io.github.imsejin.study.baekjoon.bronze

import spock.lang.Specification

class P2798Spec extends Specification {

    def "test"() {
        when:
        def actual = P2798.solve(cards as int[], blackjackNumber)

        then:
        actual == expected

        where:
        cards                                            | blackjackNumber || expected
        [1, 1, 1, 7]                                     | 8               || 3
        [5, 6, 7, 8, 9]                                  | 21              || 21
        [93, 181, 245, 214, 315, 36, 185, 138, 216, 295] | 500             || 497
    }

}
