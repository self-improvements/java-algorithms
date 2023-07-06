package io.github.imsejin.study.hackerrank

import spock.lang.Specification

class ZigZagSequenceSpec extends Specification {

    def "test"() {
        when:
        def actual = ZigZagSequence.solve(numbers as int[])

        then:
        actual == expected as int[]

        where:
        numbers               | expected
        [1, 2, 3, 4, 5, 6, 7] | [1, 2, 3, 7, 6, 5, 4]
    }

}
