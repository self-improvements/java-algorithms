package io.github.imsejin.study.programmers.lv2

import spock.lang.Specification

class L148653Spec extends Specification {

    def "test"() {
        when:
        def actual = L148653.solve(storey)

        then:
        actual == expected

        where:
        storey    | expected
        1         | 1
        10        | 1
        16        | 6
        50        | 5
        60        | 5
        98        | 3
        199       | 3
        678       | 8
        1010      | 2
        2554      | 16
        5454      | 18
        5554      | 18
        4554      | 18
        9257      | 12
        99999999  | 2
        100000000 | 1
    }

}
