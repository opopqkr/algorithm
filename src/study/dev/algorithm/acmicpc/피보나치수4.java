package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class 피보나치수4 {

    /**
     * INPUT
     * <p>
     * 10
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(solution(n));
    }

    /**
     * n의 범위가 최대 10000이기 때문에 long 타입도 불가.
     * BigInteger 타입 이용.
     *
     * @param n (2 <= n <= 10000)
     * @return dp[n]
     */
    private static BigInteger solution(int n) {
        BigInteger[] dp = new BigInteger[n + 2];
        dp[0] = BigInteger.ZERO;
        dp[1] = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2]);
        }

        return dp[n];
    }
}
