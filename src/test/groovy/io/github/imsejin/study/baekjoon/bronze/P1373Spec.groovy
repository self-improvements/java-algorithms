package io.github.imsejin.study.baekjoon.bronze

import spock.lang.Specification

class P1373Spec extends Specification {

    def "test"() {
        when:
        def actual = P1373.solve1(binary)

        then:
        actual == octal
        actual == P1373.solve2(binary)

        where:
        binary     | octal
        "0"        | "0"
        "111"      | "7"
        "1000"     | "10"
        "1010"     | "12"
        "11001100" | "314"
    }

}
