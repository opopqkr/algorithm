package study.dev.algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간합구하기5 {

    /**
     * INPUT
     * <p>
     * 4 3
     * 1 2 3 4
     * 2 3 4 5
     * 3 4 5 6
     * 4 5 6 7
     * 2 2 3 4
     * 3 4 3 4
     * 1 1 4 4
     * <p>
     * 2 4
     * 1 2
     * 3 4
     * 1 1 1 1
     * 1 2 1 2
     * 2 1 2 1
     * 2 2 2 2
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        int[][] inputs = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                inputs[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 가로 세로 누적합
        // int[][] dp = createCumulativeSum1(N, inputs);
        // 가로 누적합, 가로 세로 누적합 보다 시간 효율 떨어짐.
        int[][] dp = createCumulativeSum2(N, inputs);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()), y1 = Integer.parseInt(st.nextToken()),
                    x2 = Integer.parseInt(st.nextToken()), y2 = Integer.parseInt(st.nextToken());

            // sb.append(solution1(x1, y1, x2, y2, dp));
            sb.append(solution2(x1, y1, x2, y2, dp));
            sb.append("\n");
        }

        System.out.println(sb);
    }

    /**
     * 가로 세로 누적합.
     */
    private static int[][] createCumulativeSum1(int N, int[][] inputs) {
        int[][] dp = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + inputs[i][j];
            }
        }

        return dp;
    }

    private static int solution1(int x1, int y1, int x2, int y2, int[][] dp) {
        return dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1];
    }

    /**
     * 가로 누적합
     */
    private static int[][] createCumulativeSum2(int N, int[][] inputs) {
        int[][] dp = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = dp[i][j - 1] + inputs[i][j];
            }
        }

        return dp;
    }

    private static int solution2(int x1, int y1, int x2, int y2, int[][] dp) {
        int answer = 0;
        for (int i = x1; i <= x2; i++) {
            answer += dp[i][y2] - dp[i][y1 - 1];
        }

        return answer;
    }
}
