package io.github.imsejin.study.programmers.lv1

import spock.lang.Specification

class L160586Spec extends Specification {

    def "test"() {
        when:
        def actual = L160586.solve(keymap as String[], targets as String[])

        then:
        actual == expected as int[]

        where:
        keymap             | targets          || expected
        ["ABACD", "BCEFD"] | ["ABCD", "AABB"] || [9, 4]
        ["AA"]             | ["B"]            || [-1]
        ["AGZ", "BSSS"]    | ["ASA", "BGZ"]   || [4, 6]
    }

}
