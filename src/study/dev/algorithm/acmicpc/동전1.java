package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 동전1 {

    /**
     * INPUT
     * <p>
     * 3 10
     * 1
     * 2
     * 5
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]), k = Integer.parseInt(inputs[1]);

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(solution(k, coins));
    }

    private static int solution(int k, int[] coins) {
        // 경우의 수 저장.
        int[] dp = new int[k + 1];
        dp[0] = 1;

        for (int coin : coins) {
            // coin 이상의 비용 부터 경우의 수를 더할 수 있음.
            for (int cost = coin; cost <= k; cost++) {
                dp[cost] = dp[cost] + dp[cost - coin];
            }
        }

        return dp[k];
    }
}
