package io.github.imsejin.study.baekjoon.silver;

import io.github.imsejin.study.meta.Problem;
import io.github.imsejin.study.meta.Tag;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Problem(tags = {
        Tag.DATA_STRUCTURE,
})
public class P10866 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int count = Integer.parseInt(reader.readLine());

            Deque deque = new Deque();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < count; i++) {
                String[] arguments = Arrays.stream(reader.readLine().split(" ")).toArray(String[]::new);
                int value = arguments.length > 1 ? Integer.parseInt(arguments[1]) : -1;

                Integer answer = solve(deque, arguments[0], value);
                if (answer == null) continue;
                sb.append(answer).append('\n');
            }

            System.out.println(sb);
        }
    }

    static Integer solve(Deque deque, String command, int n) {
        switch (command) {
            case "push_front":
                deque.pushFront(n);
                return null;
            case "push_back":
                deque.pushBack(n);
                return null;
            case "pop_front":
                return deque.popFront();
            case "pop_back":
                return deque.popBack();
            case "size":
                return deque.size();
            case "empty":
                return deque.empty();
            case "front":
                return deque.front();
            case "back":
                return deque.back();
            default:
                throw new AssertionError();
        }
    }

    static class Deque {
        private final List<Integer> items = new LinkedList<>();

        public void pushFront(int n) {
            items.add(0, n);
        }

        public void pushBack(int n) {
            int cursor = Math.max(0, size());
            items.add(cursor, n);
        }

        public int popFront() {
            if (empty() == 1) return -1;
            return items.remove(0);
        }

        public int popBack() {
            if (empty() == 1) return -1;
            int cursor = Math.max(0, size() - 1);
            return items.remove(cursor);
        }

        public int size() {
            return items.size();
        }

        public int empty() {
            return size() == 0 ? 1 : 0;
        }

        public int front() {
            if (empty() == 1) return -1;
            return items.get(0);
        }

        public int back() {
            if (empty() == 1) return -1;
            return items.get(size() - 1);
        }
    }

}
