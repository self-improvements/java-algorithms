package io.github.imsejin.study.programmers

import spock.lang.Specification

class L150370Spec extends Specification {

    def "test"() {
        when:
        def actual = L150370.solve0(today, terms as String[], privacies as String[])

        then:
        actual == expected as int[]
        actual == L150370.solve1(today, terms as String[], privacies as String[])

        where:
        today        | terms                  | privacies                                                                        || expected
        "2022.05.19" | ["A 6", "B 12", "C 3"] | ["2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"]                 || [1, 3]
        "2020.01.01" | ["Z 3", "D 5"]         | ["2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"] || [1, 4, 5]
        "2020.12.28" | ["A 1"]                | ["2020.12.01 A"]                                                                 || []
        "2020.01.05" | ["B 13", "C 30"]       | ["2018.12.06 B", "2018.12.01 B", "2017.06.05 C", "2017.07.06 C"]                 || [2, 3]
    }

}
