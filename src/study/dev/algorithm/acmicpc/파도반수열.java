package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 파도반수열 {

    /**
     * INPUT
     * <p>
     * 2
     * 6
     * 12
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        long[] dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;

        for (int i = 6; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 5];
        }

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(dp[N]);
        }
    }
}
