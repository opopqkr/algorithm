package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGB거리2 {

    /**
     * INPUT
     * <p>
     * 3
     * 26 40 83
     * 49 60 57
     * 13 89 99
     * <p>
     * 3
     * 1 100 100
     * 100 1 100
     * 100 100 1
     * <p>
     * 3
     * 1 100 100
     * 100 100 100
     * 1 100 100
     * <p>
     * 6
     * 30 19 5
     * 64 77 64
     * 15 19 97
     * 4 71 57
     * 90 86 84
     * 93 32 91
     * <p>
     * 8
     * 71 39 44
     * 32 83 55
     * 51 37 63
     * 89 29 100
     * 83 58 11
     * 65 13 15
     * 47 25 29
     * 60 66 19
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] inputs = new int[N][3];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            inputs[i][0] = Integer.parseInt(st.nextToken());
            inputs[i][1] = Integer.parseInt(st.nextToken());
            inputs[i][2] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, inputs));
    }

    private static int solution(int N, int[][] inputs) {
        int answer = Integer.MAX_VALUE;
        int[][] dp;

        for (int k = 0; k < 3; k++) {
            dp = new int[N][3];
            dp[0] = inputs[0].clone();
            dp[0][k] = 1001;

            for (int i = 1; i < N; i++) {
                dp[i][0] = inputs[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
                dp[i][1] = inputs[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
                dp[i][2] = inputs[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
            }

            answer = Math.min(answer, dp[N - 1][k]);
        }

        return answer;
    }
}
