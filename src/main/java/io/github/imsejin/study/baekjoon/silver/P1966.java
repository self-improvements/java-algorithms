package io.github.imsejin.study.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

import io.github.imsejin.study.meta.Problem;
import io.github.imsejin.study.meta.Tag;

@Problem(tags = {
        Tag.DATA_STRUCTURE,
})
public class P1966 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int testCaseCount = Integer.parseInt(reader.readLine());

            for (int i = 0; i < testCaseCount; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                tokenizer.nextToken();
                int targetIndex = Integer.parseInt(tokenizer.nextToken());

                int[] priorities = Arrays.stream(reader.readLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();

                Page[] pages = new Page[priorities.length];
                for (int j = 0; j < priorities.length; j++) {
                    Page page = new Page(j, priorities[j]);
                    pages[j] = page;
                }

                int answer = solve(pages, targetIndex);
                System.out.println(answer);
            }
        }
    }

    static int solve(Page[] pages, int targetIndex) {
        if (pages.length == 1) {
            return 1;
        }

        Deque<Page> deque = new ArrayDeque<>(Arrays.asList(pages));

        int printCount = 0;
        while (!deque.isEmpty()) {
            Page page = deque.pollFirst();
            if (hasPriorPage(deque, page)) {
                deque.offerLast(page);
                continue;
            }

            printCount++;

            if (page.index == targetIndex) {
                break;
            }
        }

        return printCount;
    }

    private static boolean hasPriorPage(Deque<Page> pages, Page currentPage) {
        for (Page page : pages) {
            if (page.priority > currentPage.priority) {
                return true;
            }
        }

        return false;
    }

    // -------------------------------------------------------------------------------------------------

    static class Page {
        private final int index;
        private final int priority;

        public Page(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }

        @Override
        public String toString() {
            return "Page(index=" + index + ", priority=" + priority + ')';
        }
    }

}
