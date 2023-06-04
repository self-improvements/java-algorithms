package io.github.imsejin.study.baekjoon.silver;

import io.github.imsejin.study.meta.Problem;
import io.github.imsejin.study.meta.Tag;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@Problem(tags = {
        Tag.DATA_STRUCTURE,
})
public class P10828 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            reader.readLine();

            IntStack stack = new IntStack();
            StringBuilder sb = new StringBuilder();

            while (true) {
                String command = reader.readLine();
                if (command == null || command.isEmpty()) break;

                StringTokenizer tokenizer = new StringTokenizer(command);
                switch (tokenizer.nextToken()) {
                    case "push" -> stack.push(Integer.parseInt(tokenizer.nextToken()));
                    case "pop" -> sb.append(stack.pop()).append('\n');
                    case "size" -> sb.append(stack.size()).append('\n');
                    case "empty" -> sb.append(stack.empty()).append('\n');
                    case "top" -> sb.append(stack.top()).append('\n');
                }
            }

            System.out.println(sb);
        }
    }

    // -------------------------------------------------------------------------------------------------

    private static class IntStack {

        private final int[] items = new int[10001];

        private int cursor = 0;

        public void push(int n) {
            items[cursor] = n;
            cursor++;
        }

        public int pop() {
            if (size() == 0) return -1;

            cursor--;
            int item = items[cursor];
            items[cursor] = 0;

            return item;
        }

        public int size() {
            return cursor;
        }

        public int empty() {
            return size() == 0 ? 1 : 0;
        }

        public int top() {
            if (size() == 0) return -1;
            return items[cursor - 1];
        }

    }

}
