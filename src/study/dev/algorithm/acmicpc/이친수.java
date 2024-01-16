package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class 이친수 {

    /**
     * INPUT
     * <p>
     * 3
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        BigInteger[] dp = new BigInteger[91];
        dp[1] = BigInteger.ONE;
        dp[2] = BigInteger.ONE;

        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2]);
        }

        System.out.println(dp[N]);
    }
}
