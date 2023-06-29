package study.dev.algorithm.acmicpc;

import java.util.Scanner;

public class RGB거리 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[][] dp = new int[n + 1][3];

        for (int i = 1; i <= n; i++) {
            int redCost = in.nextInt();
            int greenCost = in.nextInt();
            int blueCost = in.nextInt();

            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + redCost;
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + greenCost;
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + blueCost;
        }

        System.out.println(Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2])));
    }
}
