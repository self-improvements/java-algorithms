package io.github.imsejin.study.baekjoon.silver

import spock.lang.Specification

class P7568Spec extends Specification {

    def "test"() {
        when:
        def actual = P7568.solve(members as String[])

        then:
        actual == expected as int[]

        where:
        members                                            | expected
        ["75 188", "82 175", "84 165"]                     | [1, 1, 1]
        ["55 185", "58 183", "88 186", "60 175", "46 155"] | [2, 2, 1, 2, 5]
    }

}
