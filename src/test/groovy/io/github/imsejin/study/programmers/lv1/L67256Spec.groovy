package io.github.imsejin.study.programmers.lv1

import spock.lang.Specification

class L67256Spec extends Specification {

    def "test"() {
        when:
        def actual = L67256.solve(numbers as int[], hand)

        then:
        actual == expected

        where:
        numbers                           | hand    || expected
        [1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5] | "right" || "LRLLLRLLRRL"
        [7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2] | "left"  || "LRLLRRLLLRR"
        [1, 2, 3, 4, 5, 6, 7, 8, 9, 0]    | "right" || "LLRLLRLLRL"
    }

}
