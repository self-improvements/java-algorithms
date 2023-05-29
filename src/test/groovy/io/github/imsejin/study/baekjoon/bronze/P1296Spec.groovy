package io.github.imsejin.study.baekjoon.bronze

import spock.lang.Specification

class P1296Spec extends Specification {

    def "test"() {
        when:
        def actual = P1296.solve(memberName, teamNames as String[])

        then:
        actual == expected

        where:
        memberName    | teamNames                                                                || expected
        "LOVE"        | ["JACOB", "FRANK", "DANO"]                                               || "FRANK"
        "JANE"        | ["THOMAS", "MICHAEL", "INDY", "LIU"]                                     || "INDY"
        "LILLY"       | ["PIERRE"]                                                               || "PIERRE"
        "MERYLOV"     | ["JOHN", "DAVE", "STEVE", "JOHN", "DAVE"]                                || "DAVE"
        "LLOL"        | ["BVERON", "CVERON", "AVERON", "DVERON"]                                 || "AVERON"
        "VELYLEOCEVE" | ["YVXHOVE", "LCOKO", "OGWSJVEVEDLE", "WGFVSJEL", "VLOLUVCBLLQVESWHEEKC"] || "VLOLUVCBLLQVESWHEEKC"
    }

}
