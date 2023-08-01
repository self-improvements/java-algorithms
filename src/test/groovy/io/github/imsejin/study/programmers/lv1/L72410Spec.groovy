package io.github.imsejin.study.programmers.lv1

import spock.lang.Specification

class L72410Spec extends Specification {

    def "test"() {
        when:
        def actual = L72410.solve(newId)

        then:
        actual == expected

        where:
        newId                         | expected
        "...!@BaT#*..y.abcdefghijklm" | "bat.y.abcdefghi"
        "z-+.^."                      | "z--"
        "=.="                         | "aaa"
        "123_.def"                    | "123_.def"
        "abcdefghijklmn.p"            | "abcdefghijklmn"
    }

}
