package study.dev.algorithm.dynamicprogramming;

import java.util.Scanner;

public class 계단오르기 {

    private static int[] dp;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        dp = new int[n + 1];

        // System.out.println(solution1(n));
        System.out.println(solution2(n));
    }

    /**
     * 내 풀이
     *
     * @param n
     * @return
     */
    private static int solution1(int n) {
        if (n == 1) {
            return dp[n] = 1;
        } else if (n == 2) {
            return dp[n] = 2;
        } else {
            return dp[n] = solution1(n - 2) + solution1(n - 1);
        }
    }

    /**
     * 강의 풀이
     *
     * @param n
     * @return
     */
    private static int solution2(int n) {
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        return dp[n];
    }
}
