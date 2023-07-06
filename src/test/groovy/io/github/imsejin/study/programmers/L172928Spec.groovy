package io.github.imsejin.study.programmers

import spock.lang.Specification

class L172928Spec extends Specification {

    def "test"() {
        when:
        def actual = L172928.solve(park as String[], routes as String[])

        then:
        actual == expected as int[]

        where:
        park                         | routes                || expected
        ["SOO", "OOO", "OOO"]        | ["E 2", "S 2", "W 1"] || [2, 1]
        ["SOO", "OXX", "OOO"]        | ["E 2", "S 2", "W 1"] || [0, 1]
        ["OSO", "OOO", "OXO", "OOO"] | ["E 2", "S 3", "W 1"] || [0, 0]
    }

}
