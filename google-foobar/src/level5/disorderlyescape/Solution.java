package level5.disorderlyescape;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static String solution(int w, int h, int s) {
        // Compute the number of configurations using Burnside's Lemma
        BigInteger configurations = BigInteger.ZERO;
        for (int i = 1; i <= w; i++) {
            for (int j = 1; j <= h; j++) {
                configurations = configurations.add(countConfigs(w, h, s, i, j));
            }
        }
        System.out.println("configurations " + configurations);

        BigInteger result = configurations.divide(getSymmetries(w, h));
        return result.toString();
    }

    private static BigInteger getSymmetries(int w, int h) {
        return factorial(w).multiply(factorial(h));
    }

    private static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        System.out.println(result);
        return result;
    }

    private static BigInteger countConfigs(int w, int h, int s, int x, int y) {
        // Compute the number of configurations for a given cycle
        BigInteger count = BigInteger.ONE;
        Map<Integer, Integer> cycleLengths = getCycleLengths(w, h, x, y);
        for (int length : cycleLengths.values()) {
            BigInteger power = BigInteger.valueOf(s).pow(length);
            count = count.multiply(power);
        }
        return count;
    }

    private static Map<Integer, Integer> getCycleLengths(int w, int h, int x, int y) {
        // Compute the cycle lengths for a given cycle
        Map<Integer, Integer> cycleLengths = new HashMap<>();
        boolean[][] visited = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (!visited[i][j]) {
                    int cycleLength = 0;
                    int curX = j;
                    int curY = i;
                    do {
                        visited[curY][curX] = true;
                        cycleLength++;
                        curX = (curX + x) % w;
                        curY = (curY + y) % h;
                    } while (curX != j || curY != i);
                    if (cycleLength > 0) {
                        cycleLengths.put(cycleLength, cycleLengths.getOrDefault(cycleLength, 0) + 1);
                    }
                }
            }
        }
        return cycleLengths;
    }
}
