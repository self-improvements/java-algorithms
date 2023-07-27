package io.github.imsejin.study.programmers

import spock.lang.Specification

class L155652Spec extends Specification {

    def "test"() {
        when:
        def actual = L155652.solve(s, skip, index)

        then:
        actual == expected

        where:
        s       | skip   | index || expected
        "aukks" | "wbqd" | 5     || "happy"
        "zibrz" | "ac"   | 1     || "bjdsb"
    }

}
