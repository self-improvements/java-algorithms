package io.github.imsejin.study.baekjoon.silver

import spock.lang.Specification

class P10816Spec extends Specification {

    def "test"() {
        when:
        def actual = P10816.solve1(cards as int[], targets as int[])

        then:
        actual == expected
        actual == P10816.solve2(cards as int[], targets as int[])

        where:
        cards                                          | targets                      || expected
        [5]                                            | [5]                          || "1"
        [71, 48]                                       | [59]                         || "0"
        [2, 2, 2, 2, 2]                                | [2, 2, 2]                    || "5 5 5"
        [6, 3, 2, 10, 10, 10, -10, -10, 7, 3]          | [10, 9, -5, 2, 3, 4, 5, -10] || "3 0 0 1 2 0 0 2"
        [-999, -10000000, 0, 10000000, 1052, 10000000] | [10000000, 0, -10000000]     || "2 1 1"
    }

}
