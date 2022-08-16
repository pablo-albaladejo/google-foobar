package level3.boombaby;

import java.math.BigInteger;

public class Solution {
    public static String bombBaby(BigInteger a, BigInteger b) {
        BigInteger steps = new BigInteger("0");
        while (b.compareTo(BigInteger.ONE) == 1) {
            steps = steps.add(a.divide(b));
            BigInteger c = a.mod(b);
            a = b;
            b = c;
        }
        if(b.compareTo(BigInteger.ZERO) == 0) return "impossible";
        if(b.compareTo(BigInteger.ONE) == 0) return String.valueOf(steps.add(a.subtract(BigInteger.ONE)));
        return String.valueOf(steps);
    }

    public static String solution(String x, String y) {
        BigInteger M = new BigInteger(x);
        BigInteger F = new BigInteger(y);
        return bombBaby(M, F);
    }
}
