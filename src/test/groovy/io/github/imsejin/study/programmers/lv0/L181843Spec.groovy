package io.github.imsejin.study.programmers.lv0

import spock.lang.Specification

class L181843Spec extends Specification {

    def "test"() {
        when:
        def actual = L181843.solve(origin, target)

        then:
        actual == expected

        where:
        origin   | target  || expected
        "banana" | "xyz"   || 0
        "melon"  | ""      || 1
        "banana" | "ana"   || 1
        "apple"  | "apple" || 1
    }

}
