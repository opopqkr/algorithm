package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FourSquares {

    /**
     * INPUT
     * <p>
     * 25
     * <p>
     * 26
     * <p>
     * 11339
     * <p>
     * 34567
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        System.out.println(solution(n));
    }

    private static int solution(int n) {
        // n 까지, 각각의 수를 만들 수 있는 제곱수의 최소 갯수를 저장.
        int[] dp = new int[n + 1];
        // 1을 만들 수 있는 제곱수는 1 * 1 = 1, 1개.
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            // j = 1부터, j의 제곱수(j * j)가 i보다 작거나 같을 때 까지,
            // 저장되어 있는 제곱수의 최소 갯수와 비교.
            // ex) i가 26일 때, 5의 제곱수와 1의 제곱수로 만드는 것이 최소 갯수.
            // j가 4일 경우 = dp[26 - (4 * 4)], 4의 제곱수 '16'(1개) + '10'을 만들기 위한 제곱수의 최소 갯수(dp[10] = 2개) = 3개.
            // j가 5일 경우 = dp[26 - (5 * 5)], 5의 제곱수 '25'(1개) + '1'을 만들기 위한 제곱수의 최소 갯수(dp[1] = 1개) = 2개.
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(dp[i - (j * j)], min);
            }
            dp[i] = min + 1;
        }

        return dp[n];
    }
}
