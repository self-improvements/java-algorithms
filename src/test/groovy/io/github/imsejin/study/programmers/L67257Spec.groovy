package io.github.imsejin.study.programmers

import spock.lang.Specification

class L67257Spec extends Specification {

    def "test"() {
        when:
        def actual = L67257.solve(expression)

        then:
        actual == expected

        where:
        expression                  | expected
        "100-200*300-500+20"        | 60420
        "50*6-3*2"                  | 300
        "0+0"                       | 0
        "999*999"                   | 998001
        "999*999*999*999*999*999*9" | 8946134820134946009
    }

}
