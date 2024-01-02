package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 부녀회장이될테야 {

    /**
     * INPUT
     * <p>
     * 2
     * 1
     * 3
     * 2
     * 3
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine()), n = Integer.parseInt(br.readLine());
            System.out.println(solution(k, n));
        }
    }

    public static int solution(int k, int n) {
        int[][] dp = new int[k + 1][n + 1];

        // 0층 초기화
        for (int room = 1; room <= n; room++) {
            dp[0][room] = room;
        }

        // 1호 초기화
        for (int floor = 1; floor <= k; floor++) {
            dp[floor][1] = 1;
        }

        for (int floor = 1; floor <= k; floor++) {
            for (int room = 2; room <= n; room++) {
                dp[floor][room] = dp[floor - 1][room] + dp[floor][room - 1];
            }
        }

        return dp[k][n];
    }
}
