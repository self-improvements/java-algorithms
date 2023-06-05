package io.github.imsejin.study.baekjoon.silver;

import io.github.imsejin.study.meta.Problem;
import io.github.imsejin.study.meta.Tag;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

@Problem(tags = {
        Tag.DATA_STRUCTURE,
})
public class P10845 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            reader.readLine();

            IntQueue queue = new IntQueue();
            StringBuilder sb = new StringBuilder();

            while (true) {
                String command = reader.readLine();
                if (command == null || command.isEmpty()) break;

                StringTokenizer tokenizer = new StringTokenizer(command);
                switch (tokenizer.nextToken()) {
                    case "push" -> queue.push(Integer.parseInt(tokenizer.nextToken()));
                    case "pop" -> sb.append(queue.pop()).append('\n');
                    case "size" -> sb.append(queue.size()).append('\n');
                    case "empty" -> sb.append(queue.empty()).append('\n');
                    case "front" -> sb.append(queue.front()).append('\n');
                    case "back" -> sb.append(queue.back()).append('\n');
                }
            }

            System.out.println(sb);
        }
    }

    // -------------------------------------------------------------------------------------------------

    private static class IntQueue {

        private final List<Integer> items = new LinkedList<>();

        public void push(int n) {
            items.add(n);
        }

        public int pop() {
            if (size() == 0) return -1;
            return items.remove(0);
        }

        public int size() {
            return items.size();
        }

        public int empty() {
            return size() == 0 ? 1 : 0;
        }

        public int front() {
            if (size() == 0) return -1;
            return items.get(0);
        }

        public int back() {
            if (size() == 0) return -1;
            return items.get(size() - 1);
        }

    }

}
