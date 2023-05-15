package io.github.imsejin.study.baekjoon.bronze

import spock.lang.Specification

class P2231Spec extends Specification {

    def "test"() {
        when:
        def actual = P2231.solve(number)

        then:
        actual == generator

        where:
        number | generator
        2      | 1
        4      | 2
        6      | 3
        8      | 4
        10     | 5
        12     | 6
        14     | 7
        16     | 8
        18     | 9
        11     | 10
        117    | 99
        216    | 198
        256    | 245
        1026   | 999
    }

}
