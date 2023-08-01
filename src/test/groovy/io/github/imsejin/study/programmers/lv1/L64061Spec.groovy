package io.github.imsejin.study.programmers.lv1

import spock.lang.Specification

class L64061Spec extends Specification {

    def "test"() {
        when:
        def actual = L64061.solve(board as int[][], moves as int[])

        then:
        actual == expected

        where:
        board                                                                                 | moves                    || expected
        [[0, 0, 0, 0, 0], [0, 0, 1, 0, 3], [0, 2, 5, 0, 1], [4, 2, 4, 4, 2], [3, 5, 1, 3, 1]] | [1, 5, 3, 5, 1, 2, 1, 4] || 4
    }

}
