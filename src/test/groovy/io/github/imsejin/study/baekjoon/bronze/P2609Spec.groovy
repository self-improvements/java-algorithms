package io.github.imsejin.study.baekjoon.bronze

import spock.lang.Specification

class P2609Spec extends Specification {

    def "gcd"() {
        when:
        def gcd = P2609.gcd(a, b)

        then:
        gcd == result

        where:
        a  | b  || result
        1  | 1  || 1
        4  | 4  || 4
        5  | 11 || 1
        24 | 8  || 8
        24 | 16 || 8
        24 | 18 || 6
    }

    def "lcm"() {
        when:
        def lcm = P2609.lcm(a, b)

        then:
        lcm == result

        where:
        a  | b  || result
        1  | 1  || 1
        4  | 4  || 4
        5  | 11 || 55
        24 | 8  || 24
        24 | 16 || 48
        24 | 18 || 72
    }

}
