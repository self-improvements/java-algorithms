package io.github.imsejin.study.programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.function.LongBinaryOperator;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/67257">수식 최대화</a>
 */
public class L67257 {

    static long solve(String expression) {
        List<Operation> operations = parse(expression);
        List<Operation> items;

        long max = 0;

        // Permutation.
        Operator[] operators = Operator.values();
        for (int i = 0; i < operators.length; i++) {
            for (int j = 0; j < operators.length; j++) {
                for (int k = 0; k < operators.length; k++) {
                    if (i == j || j == k || i == k) continue;

                    items = new LinkedList<>(operations);

                    calculate(items, operators[i]);
                    calculate(items, operators[j]);
                    calculate(items, operators[k]);

                    long result = Math.abs(items.get(0).operand);
                    if (max < result) max = result;
                }
            }
        }

        return max;
    }

    private static void calculate(List<Operation> operations, Operator operator) {
        int index;
        while (true) {
            index = findIndex(operations, operator);
            if (index == -1) break;

            long left = operations.get(index - 1).operand;
            long right = operations.get(index + 1).operand;

            long result = operator.applyAsLong(left, right);

            // Remove used operands and an operator from operations.
            operations.remove(index - 1);
            operations.remove(index - 1);
            operations.remove(index - 1);
            operations.add(index - 1, Operation.from(result));
        }
    }

    private static int findIndex(List<Operation> operations, Operator operator) {
        int size = operations.size();

        for (int i = 0; i < size; i++) {
            Operation operation = operations.get(i);
            if (Objects.equals(operation.operator, operator)) return i;
        }

        return -1;
    }

    private static List<Operation> parse(String expression) {
        String[] strings = expression.split("(?<=[0-9])(?=[+*-])|(?<=[+*-])(?=[0-9])");
        List<Operation> operations = new ArrayList<>();

        for (String s : strings) {
            Operation operation = Operation.from(s);
            operations.add(operation);
        }

        return operations;
    }

    // -------------------------------------------------------------------------------------------------

    private static class Operation {
        private final Long operand;
        private final Operator operator;

        private Operation(Long operand, Operator operator) {
            this.operand = operand;
            this.operator = operator;
        }

        public static Operation from(String item) {
            return switch (item) {
                case "+" -> new Operation(null, Operator.PLUS);
                case "-" -> new Operation(null, Operator.MINUS);
                case "*" -> new Operation(null, Operator.MULTIPLY);
                default -> new Operation(Long.parseLong(item), null);
            };
        }

        public static Operation from(long operand) {
            return new Operation(operand, null);
        }
    }

    private enum Operator implements LongBinaryOperator {
        PLUS {
            @Override
            public long applyAsLong(long left, long right) {
                return left + right;
            }
        },

        MINUS {
            @Override
            public long applyAsLong(long left, long right) {
                return left - right;
            }
        },

        MULTIPLY {
            @Override
            public long applyAsLong(long left, long right) {
                return left * right;
            }
        }
    }

}
