package io.github.imsejin.study.baekjoon.silver

import spock.lang.Specification

class P1966Spec extends Specification {

    def "test"() {
        given:
        def pages = (0..<priorities.size()).collect { new P1966.Page(it, priorities[it]) }

        when:
        def actual = P1966.solve(pages as P1966.Page[], targetIndex)

        then:
        actual == expected

        where:
        priorities         | targetIndex || expected
        [5]                | 0           || 1
        [1, 2, 3, 4]       | 2           || 2
        [1, 1, 9, 1, 1, 1] | 0           || 5
    }

}
