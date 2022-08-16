package thegrandeststaircaseofthemall;

public class Solution {
    static int solution(int n) {
        int[][] memo = new int[n + 1][n + 1];
        memo[0][0] = 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                memo[i][j] = memo[i - 1][j];
                if (j >= i) memo[i][j] += memo[i - 1][j - i];
            }
        }
        return memo[n][n] - 1;
    }
}
