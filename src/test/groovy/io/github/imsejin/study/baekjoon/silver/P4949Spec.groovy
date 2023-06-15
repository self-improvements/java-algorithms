package io.github.imsejin.study.baekjoon.silver

import spock.lang.Specification

class P4949Spec extends Specification {

    def "test"() {
        when:
        def actual = P4949.solve(line)

        then:
        actual == expected

        where:
        line                                                                  | expected
        "So when I die (the [first] I will see in (heaven) is a score list)." | true
        "[ first in ] ( first out )."                                         | true
        "([ (([( [ ] ) ( ) (( ))] )) ])."                                     | true
        "()()()."                                                             | true
        "[[a]]"                                                               | true
        "(). "                                                                | true
        " ."                                                                  | true
        "Half Moon tonight (At least it is better than no Moon at all]."      | false
        "A rope may form )( a trail in a maze."                               | false
        "Help( I[m being held prisoner in a fortune cookie factory)]."        | false
        ")))(((."                                                             | false
        "((())."                                                              | false
        "(()))."                                                              | false
        "[[[]]."                                                              | false
        "[[]]]."                                                              | false
        "[([(])]."                                                            | false
        "([)(])."                                                             | false
        "(."                                                                  | false
        ")."                                                                  | false
        "[."                                                                  | false
        "]."                                                                  | false
        "("                                                                   | false
        "([)]."                                                               | false
        "([)])."                                                              | false
        "[ [ [ ( ( ) ] ] ]"                                                   | false
        "[]][."                                                               | false
        "[([]])."                                                             | false

    }

}
