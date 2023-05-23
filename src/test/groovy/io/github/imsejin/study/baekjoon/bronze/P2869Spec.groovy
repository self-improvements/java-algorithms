package io.github.imsejin.study.baekjoon.bronze

import spock.lang.Specification

class P2869Spec extends Specification {

    def "solve"() {
        when:
        def actual = P2869.solve(ascent, descent, height)

        then:
        actual == expected

        where:
        ascent | descent | height     || expected
        10     | 9       | 10         || 1
        9      | 8       | 10         || 2
        2      | 1       | 5          || 4
        5      | 1       | 6          || 2
        5      | 2       | 10         || 3
        100    | 99      | 1000000000 || 999999901
    }

    def "solveSlowly"() {
        when:
        def actual = P2869.solveSlowly(ascent, descent, height)

        then:
        actual == expected

        where:
        ascent | descent | height     || expected
        10     | 9       | 10         || 1
        9      | 8       | 10         || 2
        2      | 1       | 5          || 4
        5      | 1       | 6          || 2
        5      | 2       | 10         || 3
        100    | 99      | 1000000000 || 999999901
    }

    def "solveVerySlowly"() {
        when:
        def actual = P2869.solveVerySlowly(ascent, descent, height)

        then:
        actual == expected

        where:
        ascent | descent | height     || expected
        10     | 9       | 10         || 1
        9      | 8       | 10         || 2
        2      | 1       | 5          || 4
        5      | 1       | 6          || 2
        5      | 2       | 10         || 3
        100    | 99      | 1000000000 || 999999901
    }

}
