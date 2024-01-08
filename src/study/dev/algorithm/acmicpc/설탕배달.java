package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <a href="https://www.acmicpc.net/problem/14916">거스름 돈 14916번</a> 유형과 동일한 문제.
 */
public class 설탕배달 {

    /**
     * INPUT
     * <p>
     * 18
     * <p>
     * 4
     * <p>
     * 6
     * <p>
     * 9
     * <p>
     * 11
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(solution1(N));
        // System.out.println(solution2(N));
    }

    /**
     * 내 풀이
     */
    private static int solution1(int N) {
        int[] sugars = new int[]{3, 5};
        int[] dp = new int[N + 6];

        for (int sugar : sugars) {
            dp[sugar] = 1;
            for (int i = sugar; i <= N; i++) {
                if (dp[i - sugar] == 0) continue;
                dp[i] = dp[sugar] + dp[i - sugar];
            }
        }

        return dp[N] == 0 ? -1 : dp[N];
    }

    /**
     * 참고 풀이
     */
    private static int solution2(int N) {
        int[] dp = new int[N + 3];
        dp[3] = 1;
        dp[5] = 1;

        for (int i = 6; i <= N; i++) {
            // 5kg 먼저 확인하는 이유는 5의 배수가 구성 수가 더 적기 때문.
            if (i % 5 == 0) {
                dp[i] = dp[i - 5] + 1;
            } else if (i % 3 == 0) {
                dp[i] = dp[i - 3] + 1;
            } else {
                if (dp[i - 5] == 0 || dp[i - 3] == 0) continue;
                dp[i] = Math.min(dp[i - 5], dp[i - 3]) + 1;
            }
        }

        return dp[N] == 0 ? -1 : dp[N];
    }
}
