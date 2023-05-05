package io.github.imsejin.study.programmers

import spock.lang.Specification

class L181848Spec extends Specification {

    def "test"() {
        when:
        def actual = L181848.solve(string)

        then:
        actual == expected

        where:
        string | expected
        "0"    | 0
        "10"   | 10
        "-512" | -512
        "8542" | 8542
    }

}
