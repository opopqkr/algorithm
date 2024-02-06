package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 오르막수 {

    /**
     * INPUT
     * <p>
     * 1
     * <p>
     * 2
     * <p>
     * 3
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(solution(N));
    }

    private static int solution(int N) {
        int[][] dp = new int[N + 1][10];

        // 1자리수 오르막수는 1개, 1로 초기화
        Arrays.fill(dp[1], 1);

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    dp[i][j] += dp[i - 1][k] % 10007;
                }
            }
        }

        return Arrays.stream(dp[N]).sum() % 10007;
    }
}
