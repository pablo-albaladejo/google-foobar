package level2.bunnyprisonerlocating;

public class Solution {
    public static long nSum(long n) {
        return n*(n+1)/2;
    }
    public static long bunny(long x, long y) {
        return nSum(x+y-1)-(y-1);
    }
    public static String solution(long x, long y) {
        return String.valueOf(bunny(x,y));
    }
}
