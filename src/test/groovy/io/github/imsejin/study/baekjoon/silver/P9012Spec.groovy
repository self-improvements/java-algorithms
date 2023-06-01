package io.github.imsejin.study.baekjoon.silver

import spock.lang.Specification

class P9012Spec extends Specification {

    def "test"() {
        when:
        def actual = P9012.solve(parenthesisString)

        then:
        actual == expected

        where:
        parenthesisString       | expected
        "(())())"               | false
        "(((()())()"            | false
        "((()()(()))(((())))()" | false
        "(()((())()("           | false
        "(("                    | false
        "))"                    | false
        "())(()"                | false
        "(()())((()))"          | true
        "()()()()(()()())()"    | true
    }

}
