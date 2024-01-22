package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <a href="https://www.acmicpc.net/problem/2156">포도주 시식 2156번</a>
 * <p>
 * - 비슷한 유형 문제 : <a href="https://www.acmicpc.net/problem/2579">계단 오르기 2579번</a>
 */
public class 포도주시식 {

    /**
     * INPUT
     * <p>
     * 6
     * 6
     * 10
     * 13
     * 9
     * 8
     * 1
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] wines = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            wines[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(solution(n, wines));
    }

    private static int solution(int n, int[] wines) {
        int[] dp = new int[n + 2];
        dp[1] = wines[1];

        if (n < 2) {
            return dp[1];
        }

        dp[2] = wines[1] + wines[2];

        for (int i = 3; i <= n; i++) {
            // 마지막 잔을 꼭 마셔야 한다는 조건이 없음.
            // 이전까지 마신 포도주의 누적합이 최대라면 그 값이 정답이 될 수 있음.
            // O = 포도주를 마심 / X = 포도주를 안마심을 예시로,
            // O O X : dp[i - 1]
            // O X O : dp[i - 2] + wines[i]
            // X O O : dp[i - 3] + wines[i - 1] + wines[i]
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2], dp[i - 3] + wines[i - 1]) + wines[i]);
        }

        return dp[n];
    }
}
