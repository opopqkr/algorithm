package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 쉬운계단수 {

    /**
     * INPUT
     * <p>
     * 1
     * <p>
     * 2
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long mod = 1000000000;
        long[][] dp = new long[N + 1][10];
        // dp[자릿수][자릿수에 들어올 숫자(0~~9)]
        // ex) dp[3][5]의 경우, 3길이의 54X, 56X의 경우의 수

        // init. 길이가 1인 자릿수의 경우 경우의 수가 한개
        for (int j = 1; j < 10; j++) {
            dp[1][j] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    // 0의 경우 자리수 옆에 0만 가능
                    dp[i][0] = dp[i - 1][1] % mod;
                } else if (j == 9) {
                    // 9의 경우 자리수 옆에 8만 가능
                    dp[i][9] = dp[i - 1][8] % mod;
                } else {
                    // ex) dp[3][5]의 경우, 3길이의 54X, 56X의 경우의 수
                    //     2자리 수의 4X의 경우의 수(4,3 / 4,5) + 2자리 수의 6X의 경우의 수(6,5 / 6,7) = 4
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
                }
            }

        }

        long answer = 0;
        for (int j = 0; j <= 9; j++) answer += dp[N][j];

        System.out.println(answer % mod);
    }
}
 
