package io.github.imsejin.study.baekjoon.bronze

import spock.lang.Specification

class P1268Spec extends Specification {

    def "test"() {
        when:
        def actual = P1268.solve(table as int[][])

        then:
        actual == expected

        where:
        table             | expected
        [[2, 3, 1, 7, 3],
         [4, 1, 9, 6, 8],
         [5, 5, 2, 4, 4],
         [6, 5, 2, 6, 7],
         [8, 4, 2, 2, 2]] | 4
        [[1, 1, 3, 1, 1],
         [5, 5, 1, 2, 1],
         [5, 5, 3, 2, 1]] | 1
        [[1, 2, 3, 4, 5],
         [5, 4, 2, 3, 1],
         [9, 8, 5, 7, 6]] | 1
        [[1, 1, 1, 1, 1],
         [1, 1, 1, 1, 1],
         [1, 3, 4, 5, 5],
         [3, 3, 3, 3, 3],
         [4, 4, 4, 4, 4]] | 3
    }

}
