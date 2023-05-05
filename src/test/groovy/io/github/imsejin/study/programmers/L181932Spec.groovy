package io.github.imsejin.study.programmers

import spock.lang.Specification

class L181932Spec extends Specification {

    def "test"() {
        when:
        def actual = L181932.solve(code)

        then:
        actual == expected

        where:
        code          | expected
        ""            | "EMPTY"
        "11"          | "EMPTY"
        "abc1abc1abc" | "acbac"
    }

}
