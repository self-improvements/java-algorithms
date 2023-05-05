package io.github.imsejin.study.programmers

import spock.lang.Specification

class L181849Spec extends Specification {

    def "test"() {
        when:
        def actual = L181849.solve(string)

        then:
        actual == expected

        where:
        string      | expected
        "123456789" | 45
        "1000000"   | 1
    }

}
