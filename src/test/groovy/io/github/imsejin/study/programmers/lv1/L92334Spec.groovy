package io.github.imsejin.study.programmers.lv1

import spock.lang.Specification

class L92334Spec extends Specification {

    def "test"() {
        when:
        def actual = L92334.solve(idList as String[], reportStrings as String[], k)

        then:
        actual == expected as int[]

        where:
        idList                             | reportStrings                                                          | k || expected
        ["muzi", "frodo", "apeach", "neo"] | ["muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"] | 2 || [2, 1, 1, 0]
        ["con", "ryan"]                    | ["ryan con", "ryan con", "ryan con", "ryan con"]                       | 3 || [0, 0]
    }

}
