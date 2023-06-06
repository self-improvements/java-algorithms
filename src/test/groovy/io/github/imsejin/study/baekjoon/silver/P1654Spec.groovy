package io.github.imsejin.study.baekjoon.silver

import spock.lang.Specification

class P1654Spec extends Specification {

    def "test"() {
        when:
        def actual = P1654.solve1(cables as int[], targetCount)

        then:
        actual == expected
        actual == P1654.solve2(cables as int[], targetCount)

        where:
        cables                                         | targetCount || expected
        [802, 743, 457, 539]                           | 11          || 200
        [5, 5, 5]                                      | 3           || 5
        [Integer.MAX_VALUE - 1, Integer.MAX_VALUE - 2] | 1000000     || 4294
    }

}
