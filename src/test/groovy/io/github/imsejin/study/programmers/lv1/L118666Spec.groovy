package io.github.imsejin.study.programmers.lv1

import spock.lang.Specification

class L118666Spec extends Specification {

    def "test"() {
        when:
        def actual = L118666.solve(survey as String[], choices as int[])

        then:
        actual == expected

        where:
        survey                         | choices         || expected
        ["AN", "CF", "MJ", "RT", "NA"] | [5, 3, 2, 7, 5] || "TCMA"
        ["TR", "RT", "TR"]             | [7, 1, 3]       || "RCJA"
    }

}
