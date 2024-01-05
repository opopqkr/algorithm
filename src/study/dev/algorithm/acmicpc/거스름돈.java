package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 거스름돈 {

    /**
     * INPUT
     * <p>
     * 13
     * <p>
     * 14
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(solution1(n));
        // System.out.println(solution2(n));
    }

    /**
     * 내 풀이
     */
    private static int solution1(int n) {
        int[] coins = new int[]{2, 5};
        int[] dp = new int[100001];

        for (int coin : coins) {
            dp[coin] = 1; // 2원, 5원 1개로 초기화.
            for (int i = coin; i <= n; i++) {
                // i 금액(거슬러 줘야 하는 금액) - 2원 or 5원이 0인 경우를 제외
                // ex1) 2원짜리 동전을 이용해 3원을 거슬러 줘야 하는 경우
                // dp[2] + dp[1]의 식이 생겨야 하지만 dp[1] 즉, 1원은 2원과 5원을 이용해 거슬러 줄 수 없기 때문에 continue.
                // ex2) 5원짜리 동전을 이용해 8원을 거슬러 줘야 하는 경우
                // dp[5] + dp[3]의 식이 생겨야 하지만 dp[3] 즉, 3원은 2원과 5원을 이용해 거슬러 줄 수 없기 때문에 continue.
                if (dp[i - coin] == 0) continue;
                dp[i] = dp[coin] + dp[i - coin];
            }
        }

        return dp[n] == 0 ? -1 : dp[n];
    }

    /**
     * 참고 풀이
     */
    private static int solution2(int n) {
        int[] dp = new int[n + 6];
        dp[0] = Integer.MAX_VALUE;
        dp[1] = Integer.MAX_VALUE;
        dp[2] = 1;
        dp[3] = Integer.MAX_VALUE;
        dp[4] = 2;
        dp[5] = 1;

        for (int i = 6; i <= n; i++) {
            // 8원을 거슬러 줘야 할 경우, 6원의 경우(2원 3개) + 2원 1개   or   3원의 경우(불가, Integer.MAX_VALUE) + 5원 1개   min
            //                     -> 6원의 경우(2원 3개) + 2원 1개 = 4개
            // 9원을 거슬러 줘야 할 경우, 7원의 경우(2원 1개, 5원 1개) + 2원 1개   or   4원의 경우(2원 2개) + 5원 1개   min
            //                     -> 두 경우 모두 2원 2개, 5원 1개가 됨으로 결과적으로 같은 경우 = 3개
            // 10원을 거슬러 줘야 할 경우, 8원의 경우(2원 4개) + 2원 1개   or   5원의 경우(5원 1개) + 5원 1개  min
            //                     -> 5원의 경우 2개
            // ...
            dp[i] = Math.min(dp[i - 2], dp[i - 5]) + 1;
        }

        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }
}
