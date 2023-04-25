package level5.disorderlyescape;

import java.math.BigInteger;
import java.util.List;

public class Solution {

    public static String solution(int w, int h, int s) {
        BigInteger grid = BigInteger.ZERO;
        BigInteger modG = Helper.getSymmetries(w, h);

        List<List<Integer>> rowPermutations = Helper.accelAsc(w);
        List<List<Integer>> columnPermutations = Helper.accelAsc(h);

        for (List<Integer> r : rowPermutations) {
            for (List<Integer> c : columnPermutations) {
                int exp = Helper.expSummation(r, c);
                BigInteger m = Helper.cycleCount(r, w).multiply(Helper.cycleCount(c, h));
                grid = grid.add(BigInteger.valueOf(s).pow(exp).multiply(m));
            }
        }

        BigInteger result = grid.divide(modG);
        return result.toString();
    }
}