package io.github.imsejin.study.baekjoon.bronze

import spock.lang.Specification

class P10250Spec extends Specification {

    def "test"() {
        when:
        def actual = P10250.solve2(h, w, n)

        then:
        actual == expected

        where:
        h  | w  | n  || expected
        6  | 12 | 10 || "402"
        30 | 50 | 72 || "1203"
        1  | 1  | 1  || "101"
        5  | 1  | 5  || "501"
        1  | 8  | 8  || "108"
        4  | 4  | 16 || "404"
    }

}
