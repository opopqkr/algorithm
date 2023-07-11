package study.dev.algorithm.dynamicprogramming;

import java.util.Arrays;
import java.util.Scanner;

public class 동전교환 {

    private static int[] dp;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = in.nextInt();
        }
        int cost = in.nextInt();
        dp = new int[cost + 1];


        System.out.println(solution(n, coins, cost));
    }

    private static int solution(int n, int[] coins, int cost) {
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= cost; j++) {
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }

        return dp[cost];
    }

}
