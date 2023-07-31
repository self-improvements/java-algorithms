package io.github.imsejin.study.programmers.lv1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/133502">햄버거 만들기</a>
 */
public class L133502 {

    static int solve(int[] ingredient) {
        Ingredient[] ingredients = new Ingredient[ingredient.length];
        for (int i = 0; i < ingredient.length; i++) {
            ingredients[i] = Ingredient.from(ingredient[i]);
        }

        LinkedList<Ingredient> stack = new LinkedList<>();

        int count = 0;
        for (Ingredient it : ingredients) {
            stack.offerLast(it);

            int stackSize = stack.size();
            if (stackSize < 4 || it != Ingredient.BREAD) continue;

            boolean valid = stack.get(stackSize - 1) == Ingredient.BREAD;
            valid &= stack.get(stackSize - 2) == Ingredient.MEAT;
            valid &= stack.get(stackSize - 3) == Ingredient.VEGETABLE;
            valid &= stack.get(stackSize - 4) == Ingredient.BREAD;

            if (valid) {
                count++;
                stack.pollLast();
                stack.pollLast();
                stack.pollLast();
                stack.pollLast();
            }
        }

        return count;
    }

    // -------------------------------------------------------------------------------------------------

    private enum Ingredient {
        BREAD,
        VEGETABLE,
        MEAT;

        private static final Map<Integer, Ingredient> cache = Arrays.stream(values())
                .collect(toMap(it -> it.ordinal() + 1, it -> it));

        public static Ingredient from(int n) {
            return cache.get(n);
        }
    }

}
