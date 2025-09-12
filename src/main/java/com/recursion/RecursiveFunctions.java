package com.recursion;

import java.util.List;

public class RecursiveFunctions {

    public static int recursiveIndexOf(List<String> list, String target) {
        return indexFrom(list, target, 0);
    }

    public static int recursiveIndexOfByIndex(List<String> list, String target, int index) {
        if (index < 0) index = 0;
        return indexFrom(list, target, index);
    }

    private static int indexFrom(List<String> list, String target, int i) {
        if (list == null || i >= list.size()) return -1;
        String val = list.get(i);
        boolean match = (target == null && val == null) ||
                (target != null && target.equals(val));
        if (match) return i;
        return indexFrom(list, target, i + 1);
    }

    public static int recursiveIndexOfEmpty(List<String> list) {
        return indexEmptyFrom(list, 0);
    }

    private static int indexEmptyFrom(List<String> list, int i) {
        if (list == null || i >= list.size()) return -1;
        if ("".equals(list.get(i))) return i;
        return indexEmptyFrom(list, i + 1);
    }

    public static int recursivePut(String target, List<String> list) {
        return putAtFirstEmpty(target, list, 0);
    }

    private static int putAtFirstEmpty(String target, List<String> list, int i) {
        if (list == null || i >= list.size()) return -1;
        if ("".equals(list.get(i))) {
            list.set(i, target);
            return i;
        }
        return putAtFirstEmpty(target, list, i + 1);
    }

    public static int recursiveRemove(List<String> list, String target) {
        return removeFrom(list, target, 0);
    }

    private static int removeFrom(List<String> list, String target, int i) {
        if (list == null || i >= list.size()) return 0;
        String val = list.get(i);
        boolean match = (target == null && val == null) ||
                (target != null && target.equals(val));
        if (match) {
            list.remove(i);
            return 1 + removeFrom(list, target, i);
        }
        return removeFrom(list, target, i + 1);
    }

    public static int recursiveSum(List<Integer> list) {
        if (list == null || list.isEmpty()) return 0;
        return list.get(0) + recursiveSum(list.subList(1, list.size()));
    }

    public static int recursiveFactorial(int n) {
        if (n < 0) throw new IllegalArgumentException("n debe ser no negativo");
        if (n == 0 || n == 1) return 1;
        return n * recursiveFactorial(n - 1);
    }

    public static int recursivePow(int base, int exponent) {
        if (exponent < 0) throw new IllegalArgumentException("exponent debe ser no negativo");
        if (exponent == 0) return 1;
        if ((exponent & 1) == 0) {
            int half = recursivePow(base, exponent / 2);
            return half * half;
        } else {
            return base * recursivePow(base, exponent - 1);
        }
    }

    public static int recursiveFibonacci(int n) {
        if (n < 0) throw new IllegalArgumentException("n debe ser no negativo");
        if (n == 0) return 0;
        if (n == 1) return 1;
        return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
    }

    public static boolean recursivePalindrome(String word) {
        if (word == null) return false;
        return isPal(word, 0, word.length() - 1);
    }

    private static boolean isPal(String s, int i, int j) {
        if (i >= j) return true;
        if (s.charAt(i) != s.charAt(j)) return false;
        return isPal(s, i + 1,j-1);
    }
}