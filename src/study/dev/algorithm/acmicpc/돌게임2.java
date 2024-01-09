package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 돌게임2 {

    /**
     * INPUT
     * <p>
     * 4
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(solution(N));
    }

    private static String solution(int N) {
        // dp[N] = 0이면 창영이가 이김, dp[N] = 1이면 상근이가 이김.
        int[] dp = new int[N + 4];
        dp[1] = 0;
        // 1개일 경우, 상근이가 가져가야 함으로 창영이가 이김.
        dp[2] = 1;
        // 2개일 경우, 상근이가 1개 가져가면 창영이가 1개 가져가야 함으로 상근이가 이김.
        dp[3] = 0;
        // 3개일 경우, 상근이가 처음 1개를 가져가고 그다음 창영이가 1개를 가져감으로 마지막 1개는 상근이가 가져가야 함으로 창영이가 이김.
        //           상근이가 처음 3개를 가져가면 창영이가 이김.

        for (int i = 4; i <= N; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 3]) + 1;
        }

        return dp[N] % 2 == 1 ? "SK" : "CY";
    }
}
