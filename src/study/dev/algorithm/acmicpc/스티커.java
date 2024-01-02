package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 스티커 {

    /**
     * INPUT
     * <p>
     * 2
     * 5
     * 50 10 100 20 40
     * 30 50 70 10 60
     * 7
     * 10 30 10 50 100 20 40
     * 20 40 30 50 60 20 80
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] stickers = new int[2][n + 1];
            int[][] dp = new int[2][n + 1];

            for (int i = 0; i < stickers.length; i++) {
                String[] scores = br.readLine().split(" ");
                for (int j = 1; j <= n; j++) {
                    stickers[i][j] = Integer.parseInt(scores[j - 1]);
                }
            }

            System.out.println(solution(n, dp, stickers));
        }
    }

    private static int solution(int n, int[][] dp, int[][] stickers) {
        dp[0][1] = stickers[0][1];
        dp[1][1] = stickers[1][1];

        for (int j = 2; j <= n; j++) {
            // 좌측 방향 대각선 한칸 밑, 좌측 방향 대각선 두칸 밑 중 Max 값 + 스티커 현재 값
            dp[0][j] = Math.max(dp[1][j - 2], dp[1][j - 1]) + stickers[0][j];
            // 좌측 방향 대각선 한칸 위, 좌측 방향 대각선 두칸 위 중 Max 값 + 스티커 현재 값
            dp[1][j] = Math.max(dp[0][j - 2], dp[0][j - 1]) + stickers[1][j];
        }

        return Math.max(dp[0][n], dp[1][n]);
    }
}
