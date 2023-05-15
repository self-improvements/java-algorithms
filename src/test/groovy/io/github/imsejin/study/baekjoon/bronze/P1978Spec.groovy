package io.github.imsejin.study.baekjoon.bronze

import spock.lang.Specification

class P1978Spec extends Specification {

    def "test"() {
        when:
        def actual = P1978.isPrime(number)

        then:
        actual == expected

        where:
        number | expected
        0      | false
        1      | false
        2      | true
        3      | true
        5      | true
        7      | true
        9      | false
    }

}
