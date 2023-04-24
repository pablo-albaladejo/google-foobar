package level5.disorderlyescape;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Helper {
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

    public static Integer summation(List<Integer> listA, List<Integer> listB) {
        int result = 0;
        for (int i = 0; i < listA.size(); i++) {
            for (int j = 0; j < listB.size(); j++) {
                result += gcd(listA.get(i), listB.get(j));
            }
        }
        return  result;
    }
}
