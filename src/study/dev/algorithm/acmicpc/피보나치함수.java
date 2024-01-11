package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치함수 {

    /**
     * INPUT
     * <p>
     * 3
     * 0
     * 1
     * 3
     * <p>
     * 2
     * 6
     * 22
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // memoization 이기 때문에, solution(int N)으로 나누어 계속 초기화 하여 값을 세팅할 필요 없음.
        int[][] dp = new int[2][41];

        dp[0][0] = 1; // 0일 때, 0출력 1회
        dp[1][0] = 0; // 0일 때, 1출력 0회

        dp[0][1] = 0; // 1일 때, 0을 0회 출력
        dp[1][1] = 1; // 1일 때, 1을 1회 출력

        // dp에 fibonacci 수열의 값을 저장 하지 않고, i에 해당하는 0의 출력 횟수와 1의 출력 횟수를 저장.
        for (int i = 2; i <= 40; i++) {
            dp[0][i] = dp[0][i - 1] + dp[0][i - 2];
            dp[1][i] = dp[1][i - 1] + dp[1][i - 2];
        }

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(dp[0][N] + " " + dp[1][N]);
        }
    }

}
