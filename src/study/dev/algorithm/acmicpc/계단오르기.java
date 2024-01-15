package study.dev.algorithm.acmicpc;

import java.util.Scanner;

public class 계단오르기 {

    /**
     * INPUT
     * <p>
     * 6
     * 10
     * 20
     * 15
     * 25
     * 10
     * 20
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] stairs = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            stairs[i] = in.nextInt();
        }

        System.out.println(solution(n, stairs));
    }

    private static int solution(int n, int[] stairs) {
        int[] dp = new int[n + 1];

        dp[1] = stairs[1];

        // n이 2일 경우.
        if (n >= 2) dp[2] = dp[1] + stairs[2];

        for (int i = 3; i <= n; i++) {
            // 연속해서 세개의 계단을 오를 수 없기 때문에,
            // 두 계단 이전까지의 점수 합 or (바로 이전 계단 점수 + 세 계단 이전까지의 점수 합) 중 Maximum
            dp[i] = Math.max(dp[i - 2], stairs[i - 1] + dp[i - 3]) + stairs[i];
        }

        return dp[n];
    }
}
