package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <a href="https://www.acmicpc.net/problem/11727">2xn 타일링 2 11727번</a>
 */
public class TwoXn타일링2 {

    /**
     * INPUT
     * <p>
     * 2
     * <p>
     * 8
     * <p>
     * 12
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 2];
        dp[1] = 1;
        dp[2] = 3;

        for (int i = 3; i < dp.length; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 2]) % 10007;
        }

        System.out.println(dp[n]);
    }
}
