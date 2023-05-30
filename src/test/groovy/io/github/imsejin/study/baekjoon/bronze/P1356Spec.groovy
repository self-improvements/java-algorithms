package io.github.imsejin.study.baekjoon.bronze

import spock.lang.Specification

class P1356Spec extends Specification {

    def "test"() {
        when:
        def actual = P1356.solve(number)

        then:
        (actual == "YES") == expected

        where:
        number   | expected
        1        | false
        98       | false
        112      | false
        12345    | false
        4729382  | false
        11       | true
        100      | true
        1236     | true
        1221     | true
        42393338 | true
    }

    def "Gets int at"() {
        when:
        def actual = P1356.getIntAt(number, i)

        then:
        actual == expected

        where:
        number | i  || expected
        0      | 0  || 0
        9      | 0  || 9
        12     | 0  || 2
        12     | 1  || 1
        8192   | 3  || 8
        16384  | 1  || 8
        16384  | 3  || 6
        16384  | 10 || 0
    }

}
