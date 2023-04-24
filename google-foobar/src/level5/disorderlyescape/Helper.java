package level5.disorderlyescape;

import java.math.BigInteger;

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
}
