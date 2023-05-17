package io.github.imsejin.study.baekjoon.silver

import spock.lang.Specification

class P1676Spec extends Specification {

    def "solve1"() {
        when:
        def actual = P1676.solve1(number)

        then:
        actual == expected

        where:
        number | expected
        0      | 0
        1      | 0
        2      | 0
        3      | 0
        4      | 0
        5      | 1
        6      | 1
        7      | 1
        8      | 1
        9      | 1
        10     | 2
        11     | 2
        12     | 2
        13     | 2
        14     | 2
        15     | 3
        16     | 3
        17     | 3
        18     | 3
        19     | 3
        20     | 4
        21     | 4
        22     | 4
        23     | 4
        24     | 4
        25     | 6
        26     | 6
        27     | 6
        28     | 6
        29     | 6
        30     | 7
        31     | 7
        32     | 7
        33     | 7
        34     | 7
    }

    def "solve2"() {
        when:
        def actual = P1676.solve2(number)

        then:
        actual == expected

        where:
        number | expected
        0      | 0
        1      | 0
        2      | 0
        3      | 0
        4      | 0
        5      | 1
        6      | 1
        7      | 1
        8      | 1
        9      | 1
        10     | 2
        11     | 2
        12     | 2
        13     | 2
        14     | 2
        15     | 3
        16     | 3
        17     | 3
        18     | 3
        19     | 3
        20     | 4
        21     | 4
        22     | 4
        23     | 4
        24     | 4
        25     | 6
        26     | 6
        27     | 6
        28     | 6
        29     | 6
        30     | 7
        31     | 7
        32     | 7
        33     | 7
        34     | 7
    }

    def "solve3"() {
        when:
        def actual = P1676.solve3(number)

        then:
        actual == expected

        where:
        number | expected
        0      | 0
        1      | 0
        2      | 0
        3      | 0
        4      | 0
        5      | 1
        6      | 1
        7      | 1
        8      | 1
        9      | 1
        10     | 2
        11     | 2
        12     | 2
        13     | 2
        14     | 2
        15     | 3
        16     | 3
        17     | 3
        18     | 3
        19     | 3
        20     | 4
        21     | 4
        22     | 4
        23     | 4
        24     | 4
        25     | 6
        26     | 6
        27     | 6
        28     | 6
        29     | 6
        30     | 7
        31     | 7
        32     | 7
        33     | 7
        34     | 7
    }

}
