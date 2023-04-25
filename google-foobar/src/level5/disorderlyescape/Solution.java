package level5.disorderlyescape;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
    public static int gcd(int x, int y) {
        int a = Math.abs(x);
        int b = Math.abs(y);
        while (b > 1) {
            int c = a % b;
            a = b;
            b = c;
        }
        return b == 1 ? 1 : a;
    }

    public static List<List<Integer>> accelAsc(int n) {
        List<List<Integer>> result = new ArrayList<>();
        accelAscYield(n, result);
        return result;
    }

    public static void accelAscYield(int n, List<List<Integer>> result) {
        int[] a = new int[n + 1];
        int k = 1;
        int y = n - 1;
        List<Integer> partition = new ArrayList<>();
        while (k != 0) {
            int x = a[k - 1] + 1;
            k -= 1;
            while (2 * x <= y) {
                a[k] = x;
                y -= x;
                k += 1;
            }
            int l = k + 1;
            while (x <= y) {
                a[k] = x;
                a[l] = y;
                for (int i = 0; i <= k + 1; i++) {
                    partition.add(a[i]);
                }
                result.add(new ArrayList<>(partition));
                partition.clear();
                x += 1;
                y -= 1;
            }
            a[k] = x + y;
            y = x + y - 1;
            for (int i = 0; i <= k; i++) {
                partition.add(a[i]);
            }
            result.add(new ArrayList<>(partition));
            partition.clear();
        }
    }

    public static Integer expSummation(List<Integer> listA, List<Integer> listB) {
        int result = 0;

        for (Integer i : listA) {
            for (Integer j : listB) {
                result += gcd(i, j);
            }
        }

        return result;
    }


    public static BigInteger cycleCount(List<Integer> partition, int n) {
        BigInteger cc = factorial(n);
        Map<Integer, Integer> counter = new HashMap<>();

        for (Integer p : partition) {
            counter.put(p, counter.getOrDefault(p, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            int a = entry.getKey();
            int b = entry.getValue();
            cc = cc.divide(BigInteger.valueOf(a).pow(b).multiply(factorial(b)));
        }
        return cc;
    }

    public static BigInteger getSymmetries(int w, int h) {
        return factorial(w).multiply(factorial(h));
    }
    public static String solution(int w, int h, int s) {
        BigInteger grid = BigInteger.ZERO;
        BigInteger modG = getSymmetries(w, h);

        List<List<Integer>> rowPermutations = accelAsc(w);
        List<List<Integer>> columnPermutations = accelAsc(h);

        for (List<Integer> r : rowPermutations) {
            for (List<Integer> c : columnPermutations) {
                int exp = expSummation(r, c);
                BigInteger m = cycleCount(r, w).multiply(cycleCount(c, h));
                grid = grid.add(BigInteger.valueOf(s).pow(exp).multiply(m));
            }
        }

        BigInteger result = grid.divide(modG);
        return result.toString();
    }
}