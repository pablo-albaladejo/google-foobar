package level5.disorderlyescape;

import java.math.BigInteger;
import java.util.List;

public class Solution {

    public static String solution(int w, int h, int s) {
        BigInteger grid = BigInteger.ZERO;
        BigInteger modG = Helper.getSymmetries(w, h);

        List<List<Integer>> rowPermutations = Helper.accelAsc(h);
        List<List<Integer>> columnPermutations = Helper.accelAsc(w);

        for (List<Integer> r : rowPermutations) {
            for (List<Integer> c : columnPermutations) {
                int exp = Helper.expSummation(r, c);
                int m = Helper.cycleCount(r, w) * Helper.cycleCount(c, h);
                grid = grid.add(BigInteger.valueOf(m * (int)Math.pow(s,exp)));
            }
        }
        System.out.println("num " + grid);
        System.out.println("dem " + modG);
        BigInteger result = grid.divide(modG);
        return result.toString();
    }
}