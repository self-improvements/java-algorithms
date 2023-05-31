package io.github.imsejin.study.baekjoon.silver

import spock.lang.Specification

class P1920Spec extends Specification {

    def "Binary search"() {
        when:
        def index = P1920.binarySearch(numbers as int[], target)

        then:
        index == expected

        where:
        numbers                                            | target || expected
        []                                                 | 0      || -1
        [2]                                                | 1      || -1
        [2]                                                | 2      || 0
        [5, 6]                                             | 6      || 1
        [1, 2, 3, 4]                                       | 3      || 2
        [1, 2, 3, 4, 5]                                    | 6      || -1
        [1, 2, 3, 4, 5]                                    | 0      || -1
        [2, 8, 11, 13, 14, 21, 32, 57, 62, 64, 88, 90, 92] | 90     || 11
        [2, 8, 11, 13, 14, 21, 32, 57, 62, 64, 88, 90, 92] | 13     || 3
        [2, 8, 11, 13, 14, 21, 32, 57, 62, 64, 88, 90, 92] | -5     || -1
        [2, 8, 11, 13, 14, 21, 32, 57, 62, 64, 88, 90, 92] | 19     || -1
        [2, 8, 11, 13, 14, 21, 32, 57, 62, 64, 88, 90, 92] | 100    || -1
    }

}
