package io.github.imsejin.study.baekjoon.silver;

import io.github.imsejin.study.meta.Problem;
import io.github.imsejin.study.meta.Tag;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.util.Comparator.comparingInt;

@Problem(tags = {
        Tag.SORTING,
})
public class P10814 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Member[] members = new Member[Integer.parseInt(reader.readLine())];

            for (int i = 0; i < members.length; i++) {
                String line = reader.readLine();
                members[i] = Member.from(line, i);
            }

            Arrays.sort(members, comparingInt(Member::getAge).thenComparing(Member::getId));

            StringBuilder sb = new StringBuilder();
            for (Member member : members) {
                sb.append(member.getAge()).append(' ').append(member.getName()).append('\n');
            }

            System.out.println(sb);
        }
    }

    private static class Member {
        private final int age;
        private final String name;
        private final int id;

        private Member(int age, String name, int id) {
            this.age = age;
            this.name = name;
            this.id = id;
        }

        public static Member from(String line, int id) {
            StringTokenizer tokenizer = new StringTokenizer(line);
            return new Member(Integer.parseInt(tokenizer.nextToken()), tokenizer.nextToken(), id);
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }
    }

}
