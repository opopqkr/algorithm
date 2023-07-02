package study.dev.algorithm.dynamicprogramming;

import java.util.Scanner;

public class 돌다리건너기 {

    private static int[] dp;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        dp = new int[n + 2];

        System.out.println(solution(n));
    }

    private static int solution(int n) {
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n + 1; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        return dp[n + 1];
    }
}
