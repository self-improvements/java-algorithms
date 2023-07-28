package io.github.imsejin.study.programmers.lv1

import spock.lang.Specification

class L178871Spec extends Specification {

    def "test"() {
        when:
        def actual = L178871.solve(players as String[], callings as String[])

        then:
        actual == expected as String[]

        where:
        players                               | callings                       || expected
        ["mumu", "soe", "poe", "kai", "mine"] | ["kai", "kai", "mine", "mine"] || ["mumu", "kai", "mine", "soe", "poe"]
    }

}
